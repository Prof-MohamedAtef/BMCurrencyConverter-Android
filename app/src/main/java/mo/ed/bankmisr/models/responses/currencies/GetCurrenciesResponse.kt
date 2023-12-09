package mo.ed.bankmisr.models.responses.currencies

data class GetCurrenciesResponse(
    val success: Boolean,
    val symbols: Symbols
)