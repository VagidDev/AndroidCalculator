package md.zibliuc.calculator.core.validators

object ServiceValidator {
    private val validators: List<Validator> = listOf(
        DotCountValidator(),
        DotStartValidator(),
        ZeroStartValidator(),
    )

    private fun validate(str: String): Boolean {
        for ( validator in validators ) {
            val response: Boolean = validator.validate(str)
            if (!response)
                return false
        }

        return true
    }

}