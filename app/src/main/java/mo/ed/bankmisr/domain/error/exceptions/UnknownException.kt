package mo.ed.bankmisr.domain.error.exceptions

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import mo.ed.bankmisr.R

class UnknownException : BaseException {
    override var message: String = ""

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface ServiceProviderEntryPoint {

    }

    constructor(context: Context, throwable: Throwable?) : super(throwable) {
        val hiltEntryPoint = EntryPointAccessors.fromApplication(context, ServiceProviderEntryPoint::class.java)

        // some function for analytics with Firebase for example
//        val analyticsService = hiltEntryPoint.analyticsService()
//        analyticsService.sendError(throwable)

        // text provider for providing accurate text for example - i will avoid it for now
//        message = hiltEntryPoint.textProvider().getText()
        message = context.getString(R.string.error_generic_msg)
    }

    constructor(context: Context) : super() {
        kotlin.runCatching {
            val hiltEntryPoint = EntryPointAccessors.fromApplication(context, ServiceProviderEntryPoint::class.java)
//            message = hiltEntryPoint.textProvider().getText(R.string.error_generic_msg)
            message = context.getString(R.string.error_generic_msg)
        }.onFailure {
            message = "Something went wrong, please try again later."
        }
    }
}