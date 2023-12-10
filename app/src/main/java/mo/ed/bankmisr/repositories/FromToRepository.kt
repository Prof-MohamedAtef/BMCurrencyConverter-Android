package mo.ed.bankmisr.repositories

import android.content.Context
import mo.ed.bankmisr.api.ApiService
import mo.ed.bankmisr.domain.error.exceptions.UnknownException
import mo.ed.bankmisr.utils.NetworkResultWrapper
import mo.ed.bankmisr.utils.Result
import mo.ed.bankmisr.utils.Result.Failure
import mo.ed.bankmisr.utils.Result.Success

import java.lang.Exception
import javax.inject.Inject

class FromToRepository @Inject constructor(
    private val context: Context,
    internal val apiService: ApiService,
) : BaseRepo(){
    suspend fun getCurrencies(): Result<Any> {
        kotlin.runCatching {
            apiService.getCurrencies().also {
                when (it) {
                    is NetworkResultWrapper.Success<*, *> -> {
                        return Success(it.data)
                    }

                    is NetworkResultWrapper.Failure -> {
                        return Failure(it.throwable as? Exception)
                    }

                    is NetworkResultWrapper.NotModified -> {
                        return Failure()
                    }

                    is NetworkResultWrapper.NetworkNotReachable -> {
                        return Failure()
                    }

                    is NetworkResultWrapper.NotDataFound -> {
                        return Success(null)
                    }
                }
            }
            }.onFailure { return handleError(context, it) }
            return Failure(UnknownException(context))
        }
}