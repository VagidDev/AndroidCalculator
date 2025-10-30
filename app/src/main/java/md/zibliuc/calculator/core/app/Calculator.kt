package md.zibliuc.calculator.core.app

import java.util.regex.Pattern

object Calculator {
    private val symbols: Map<Int, Char> = mapOf(
        0 to '+',
        1 to '-',
        2 to '*',
        3 to '/',
    )
    //need to change priority of operation and output
    fun calculate(expression: String) : String {

        val expression: MutableList<String> = parse(expression)

        for (i in (symbols.size - 1) downTo 0) {
            val operation: String? = symbols[i]?.toString()

            operation?.let {
                while (expression.contains(operation)) {
                    val currentOperation = expression.find({ it == operation })

                    currentOperation?.let {
                        val indexOfOperation = expression.indexOf(currentOperation)
                        val result =
                            calculatePair(expression[indexOfOperation - 1], currentOperation, expression[indexOfOperation + 1])
                        //debug
                        println("Pair: " + expression[indexOfOperation - 1] + currentOperation
                                + expression[indexOfOperation + 1] + "=" + result)

                        expression[indexOfOperation] = result
                        expression.removeAt(indexOfOperation + 1)
                        expression.removeAt(indexOfOperation - 1)
                    }
                }
            }
        }

        return expression[0]
    }

    fun calculatePair(x: String, action: String, y: String) : String {
        val xValue = x.toDouble()
        val yValue = y.toDouble()

        val result = when (action) {
            "*" -> xValue * yValue
            "/" -> xValue / yValue
            "-" -> xValue - yValue
            "+" -> xValue + yValue
            else -> 0
        }
        return result.toString()
    }

    fun parse(input: String) : MutableList<String> {
        val numbers = input.split("+", "-", "/", "*")
        val operations = input.filter { it in symbols.values }

        val expression: MutableList<String> = mutableListOf()

        for (i in 0 until numbers.size) {
            expression.add(numbers[i])
            if (i < numbers.size - 1)
                expression.add(operations[i].toString())
        }

        return expression
    }
}