package mo.ed.bankmisr.utils

sealed class Result<out T> {

    data class Success<out T>(val data: T?, var isInternetAvailable: Boolean? = true) : Result<T>()
    data class Loading(val nothing: Nothing? = null) : Result<Nothing>()
    data class Failure(val exception: Exception? = null, val data: Any? = null) : Result<Nothing>()
}
