package md.zibliuc.calculator.core.validators

interface Validator {
    fun validate(str: String) : Boolean
}