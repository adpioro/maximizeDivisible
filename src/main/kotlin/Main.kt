var steps = 6

fun main() {
    val userInput = readln()
        .substringAfter('[')
        .substringBefore(']')
        .split(", ")

    // List of int, based on user input
    var numsList = userInput.map { it.toInt() }
        .toMutableList()

    // check for divisibility by 3
    for (num in numsList.indices) {
        if (numsList[num] % 3 != 0) {
            steps -= 3 - numsList[num] % 3
            numsList[num] = makeDivisibleByThree(numsList[num])
        }
    }

    // maximize sum of 3 integers
    val maximizationTimes = steps / 3
    repeat(maximizationTimes) {
        val maximized = maximizeSum(numsList)
        numsList = maximized
        steps -= 3
    }
    println(numsList)
}

fun maximizeSum(numsList: MutableList<Int>): MutableList<Int> {

    val orgNums = numsList.map { it.toString().toCharArray() }
        .toMutableList()

    // create complementary list, where every number is made of digits complement to 9
    val complementaryNums = mutableListOf<Int>()

    for (numPos in orgNums.indices) {
        var tempNum = mutableListOf<Int>()
        var sumOfDigit = 0
        for (digit in orgNums[numPos].indices) {
            val tempDigit = (9 - orgNums[numPos][digit].digitToInt())
            sumOfDigit += tempDigit
            tempNum.add(tempDigit)
        }
        // to keep divisibility by 3 sum of possible addition must be at lest 3
        if (sumOfDigit < 3) {
            tempNum = mutableListOf(0)
        }
        complementaryNums.add(tempNum.joinToString("").toInt())
    }

    val maxToAdd = complementaryNums.maxOrNull() ?: 0
    val maxPos = complementaryNums.indexOf(maxToAdd)
    val maximizedNum = numsList[maxPos].toString().toCharArray()

    // add 3 or nothing to num to keep it divisible and maximize sum of all
    var toAdd = if (maxToAdd != 0) 3 else 0
    var digitPos = 0
    while (toAdd > 0 && digitPos in maximizedNum.indices) {
        while (maximizedNum[digitPos] < '9' && toAdd > 0) {
            maximizedNum[digitPos] = maximizedNum[digitPos] + 1
            toAdd--
        }
        digitPos++
    }
    numsList[maxPos] = maximizedNum.joinToString("").toInt()

    return numsList
}

fun makeDivisibleByThree(num: Int): Int {
    var needed = 3 - (num % 3)
    val tempNum = num.toString().toCharArray()

    // increasing num digits value starting from the first
    var digitPos = 0
    while (needed > 0) {
        if (tempNum[digitPos] < '9') {
            tempNum[digitPos] = tempNum[digitPos] + 1
            needed--
        } else {
            digitPos++
        }
    }

    val result = tempNum.joinToString("").toInt()
    return result
}