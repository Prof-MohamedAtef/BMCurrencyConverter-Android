package mo.ed.bankmisr.repositories

import mo.ed.bankmisr.api.ApiService
import mo.ed.bankmisr.utils.NetworkResultWrapper
import mo.ed.bankmisr.utils.Result
import mo.ed.bankmisr.utils.Result.Failure
import mo.ed.bankmisr.utils.Result.Success
import mo.ed.bankmisr.utils.Result.Loading
import java.lang.Exception
import javax.inject.Inject

class FromToRepository @Inject constructor(
    internal val apiService: ApiService,
) {
    suspend fun getUsers(): Result<Any> {
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
                        Result.Success(null)
                    }
                }
            }
        }
    }
}