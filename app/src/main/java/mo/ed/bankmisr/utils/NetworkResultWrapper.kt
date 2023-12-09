package mo.ed.bankmisr.utils

import retrofit2.Response

sealed class NetworkResultWrapper<out T> {

    data class Success<out T, P>(val data: T?, val response: P? = null) : NetworkResultWrapper<T>()
    object NotModified : NetworkResultWrapper<Nothing>()
    object NotDataFound : NetworkResultWrapper<Nothing>()
    data class Failure(val throwable: Throwable? = null, val response: Response<*>? = null) : NetworkResultWrapper<Nothing>()
    data class NetworkNotReachable(val throwable: Throwable? = null) : NetworkResultWrapper<Nothing>()
}
