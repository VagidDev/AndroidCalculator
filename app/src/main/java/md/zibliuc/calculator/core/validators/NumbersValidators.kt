package md.zibliuc.calculator.core.validators

class DotCountValidator : Validator {

    override fun validate(str:String): Boolean {
        val dotCount = str.count({ symbol -> symbol == '.' })
        return dotCount <= 1
    }
}

class DotStartValidator : Validator {
    override fun validate(str: String): Boolean {
        if (str.startsWith("."))
            return false
        else if (str.startsWith("0."))
            return true

        return true
    }
}

class ZeroStartValidator : Validator {
    override fun validate(str: String): Boolean {
        val isStartsWithZero: Boolean = str.startsWith("0")
        if (isStartsWithZero && str.length == 1)
            return true
        else if (isStartsWithZero && str.length > 1)
            return false

        return true
    }
}

class LastActionValidator : Validator {
    private val actions: List<Char> = listOf(
        '+', '-', '/', '*'
    )

    override fun validate(str: String): Boolean {
        if (str.isBlank())
            return true

        return !actions.contains(str.last())
    }
}

// Not used
class NumberValidator : Validator {
    override fun validate(str: String): Boolean {
        //if (str.matches("[]"))
        TODO("Need to implement logic for checking input number")
    }
}