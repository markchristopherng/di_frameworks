package au.com.auspost.android.feature.koin

import android.app.Application
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
        }
    }
}