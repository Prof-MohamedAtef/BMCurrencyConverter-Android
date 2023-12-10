package mo.ed.bankmisr

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}