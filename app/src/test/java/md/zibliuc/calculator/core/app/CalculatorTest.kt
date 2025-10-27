package md.zibliuc.calculator.core.app

import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {
    @Test
    fun calculate() {
        // TODO
    }

    @Test
    fun parse_ShouldReturnTwoArray() {
        val expectation = listOf(
            "38","*", "69", "+", "98"
        )

        val actual = Calculator.parse("38*69+98")

        assertEquals(expectation, actual)
    }

}