package mo.ed.bankmisr.features.fromtofeature.uiscreen

import mo.ed.bankmisr.models.responses.currencies.Symbols

data class BaseUIState(
    open val isLoading: Boolean = false,
    open val hasError: Boolean = false,
    open val symbols: List<Symbols>? = emptyList(),
    open val errorMessage: String? = null,
    open val isEmptyState: Boolean = false
)