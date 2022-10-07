import kotlin.test.Test
import kotlin.test.assertEquals

internal class DivisibilityTest {

    @Test
    fun testDivisibiltyByAddingTwo() {
        val testNum = 1
        val expected = 3
        assertEquals(expected, makeDivisibleByThree(testNum))
    }

    @Test
    fun testDivisibiltyByAddingOne() {
        val testNum = 2
        val expected = 3
        assertEquals(expected, makeDivisibleByThree(testNum))
    }

    @Test
    fun testAdditionToSecondDigit() {
        val testNum = 976
        val expected = 996
        assertEquals(expected, makeDivisibleByThree(testNum))
    }

    @Test
    fun testExampleFirst() {
        val testNum = 784
        val expected = 984
        assertEquals(expected, makeDivisibleByThree(testNum))
    }

    @Test
    fun testExampleSecond() {
        val testNum = 4765
        val expected = 6765
        assertEquals(expected, makeDivisibleByThree(testNum))
    }

    @Test
    fun testExampleThird() {
        val testNum = 5291
        val expected = 6291
        assertEquals(expected, makeDivisibleByThree(testNum))
    }
}