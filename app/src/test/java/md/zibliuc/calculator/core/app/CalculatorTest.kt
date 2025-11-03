package md.zibliuc.calculator.core.app

import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {
    @Test
    fun calculate_SumTwoNumbers() {
        val expression = "9+6"
        val expectation = "15.0"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }

    @Test
    fun calculate_SumThreeNumbers() {
        val expression = "4+5+6"
        val expectation = "15.0"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }

    @Test
    fun calculate_MultiplyAndSumThreeNumbers() {
        val expression = "4+5*6"
        val expectation = "34.0"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }

    @Test
    fun calculate_BigExpression() {
        //65+32-68/21+44*22/74*0.17
        val expression = "65+32-68/21+44*22/74*0.17"
        val expectation = "95.9856885457"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }

    @Test
    fun calculate_BigExpressionWithUnorderedMultiplies() {
        //55+36-84*98/14-25/4*6*2/4
        val expression = "55+36-84*98/14-25/4*6*2/4"
        val expectation = "-515.75"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }
    /*
    @Test
    fun calculate_MultiplyAndMinusThreeNumbers() {
        //bagreport suka (need to fix parsing with minus in front)
        val expression = "-4-5*6"
        val expectation = "-26.0"
        val actual = Calculator.calculate(expression)

        assertEquals(expectation, actual)
    }
    */

    @Test
    fun parse_ShouldReturnTwoArray() {
        val expectation = listOf(
            "38","*", "69", "+", "98"
        )

        val actual = Calculator.parse("38*69+98")

        assertEquals(expectation, actual)
    }

    @Test
    fun calculatePair_ShouldMultiplyTwoIntegerNumbers() {
        val expectation = "33.0"

        val actual = Calculator.calculatePair("11", "*", "3")

        assertEquals(expectation, actual)
    }


    @Test
    fun calculatePair_ShouldDivideTwoIntegerNumbers() {
        val expectation = "11.0"

        val actual = Calculator.calculatePair("33", "/", "3")

        assertEquals(expectation, actual)
    }

    @Test
    fun calculatePair_ShouldDivideTwoIntegerNumbersWithDoubleResult() {
        val expectation = "0.25"

        val actual = Calculator.calculatePair("1", "/", "4")

        assertEquals(expectation, actual)
    }

    @Test
    fun calculatePair_ShouldDivideTwoDoubleNumbersWithDoubleResult() {
        val expectation = "0.5"

        val actual = Calculator.calculatePair("0.25", "/", "0.5")

        assertEquals(expectation, actual)
    }
}