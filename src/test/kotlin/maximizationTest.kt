import kotlin.test.Test
import kotlin.test.assertEquals

internal class MaximizationTest {

    @Test
    fun singleMaximization() {
        val testList = mutableListOf(888)
        val expected = mutableListOf(999)
        assertEquals(expected, maximizeSum(testList))
    }

    @Test
    fun firstOfTwoMaximization() {
        val testList = mutableListOf(777, 987)
        val expected = mutableListOf(987, 987)
        assertEquals(expected, maximizeSum(testList))
    }

    @Test
    fun testMaximizationOfLast() {
        val testList = mutableListOf(984, 6765, 6291)
        val expected = mutableListOf(984, 6765, 9291)
        assertEquals(expected, maximizeSum(testList))
    }
}