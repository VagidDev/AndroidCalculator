package md.zibliuc.calculator.core.app

import java.util.regex.Pattern

object Calculator {
    private val symbols: List<Char> = listOf(
        '+', '-', '/', '*'
    )

    fun calculate(expression: String) : Double {


        return 0.0
    }

    fun parse(input: String) : List<String> {
        val numbers = input.split("+", "-", "/", "*")
        val operations = input.filter { it in symbols }

        val expression: MutableList<String> = mutableListOf()

        for (i in 0 until numbers.size) {
            expression.add(numbers[i])
            if (i < numbers.size - 1)
                expression.add(operations[i].toString())
        }

        return expression
    }
}