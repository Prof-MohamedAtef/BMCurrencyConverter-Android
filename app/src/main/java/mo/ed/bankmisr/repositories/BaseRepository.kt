package mo.ed.bankmisr.repositories

import android.content.Context
import mo.ed.bankmisr.utils.Result
import java.lang.Exception

open class BaseRepo {
    fun handleError(context: Context, it: Throwable): Result.Failure {
        return when (it) {
            is Exception -> {
                Result.Failure(it)
            }
            else -> {
                Result.Failure(Exception())
            }
        }
    }
}