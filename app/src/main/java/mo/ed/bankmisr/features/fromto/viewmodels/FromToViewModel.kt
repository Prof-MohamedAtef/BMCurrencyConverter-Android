package mo.ed.bankmisr.features.fromto.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import mo.ed.bankmisr.di.AppModule
import javax.inject.Inject

@HiltViewModel
class FromToViewModel @Inject constructor(
    @AppModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
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