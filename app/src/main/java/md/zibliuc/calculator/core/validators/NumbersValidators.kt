package md.zibliuc.calculator.core.validators

class DotCountValidator : Validator {

    override fun validate(str:String): Boolean {
        val dotCount = str.count({ symbol -> symbol == '.' })
        return dotCount <= 1
    }
}

class DotStartValidator : Validator {
    override fun validate(str: String): Boolean {
        return !str.startsWith(".")
    }
}

class ZeroStartValidator : Validator {
    override fun validate(str: String): Boolean {
        return !str.startsWith("0")
    }
}

class NumberValidator : Validator {
    override fun validate(str: String): Boolean {
        //if (str.matches("[]"))
        TODO("Need to implement logic for checking input number")
    }
}