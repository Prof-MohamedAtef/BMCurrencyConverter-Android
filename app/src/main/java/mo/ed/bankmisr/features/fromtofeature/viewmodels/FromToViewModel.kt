package mo.ed.bankmisr.features.fromtofeature.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mo.ed.bankmisr.di.AppModule
import mo.ed.bankmisr.features.fromtofeature.uiscreen.BaseUIState
import mo.ed.bankmisr.interactor.FromToInteractor
import mo.ed.bankmisr.models.responses.currencies.Symbols
import mo.ed.bankmisr.utils.Result
import javax.inject.Inject

@HiltViewModel
class FromToViewModel @Inject constructor(
    @AppModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val accountsInteractor: FromToInteractor,
) : ViewModel() {

    var _screenUiState = MutableStateFlow(BaseUIState())
    val screenUiState = _screenUiState.asStateFlow()
    fun getCurrencies() {
        viewModelScope.launch(ioDispatcher) {
            accountsInteractor.getCurrencies().let { response ->
                when (response) {
                    is Result.Loading -> {
                        _screenUiState.update {
                            it.copy(isLoading = true)
                        }
                    }
                    is Result.Success -> {
                        val symbols = response.data as? List<Symbols>
                        _screenUiState.update {
                            it.copy(symbols = symbols)
                        }
                    }
                    is Result.Failure -> {
                        _screenUiState.update {
                            it.copy(hasError = true, errorMessage = "Exception: failure in api call")
                        }
                        Log.e("failure", " failure in api call")
                    }

                    else -> {}
                }
            }
        }
    }

}