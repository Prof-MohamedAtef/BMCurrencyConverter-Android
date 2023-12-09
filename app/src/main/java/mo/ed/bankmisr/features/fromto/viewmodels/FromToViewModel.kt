package mo.ed.bankmisr.features.fromto.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class FromToViewModel : ViewModel() {
    fun getCurrencies() {
        viewModelScope.launch(ioDispatcher) {
            regularExpressionsInteractor.fetchRegularExpressions().let { response ->
                when (response) {
                    is Result.Success -> {
                        val getExpression = response.data as? List<RegularExpressionEntity>
                        Timber.d("Expression fetched successfully: $getExpression")
                    }
                    is Result.Failure -> {
                        Timber.e("Fail to fetch the Expression")
                    }

                    else -> {}
                }
            }
        }
    }

}