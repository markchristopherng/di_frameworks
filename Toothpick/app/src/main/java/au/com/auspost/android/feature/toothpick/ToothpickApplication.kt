package au.com.auspost.android.feature.toothpick

import android.app.Application
import toothpick.ktp.KTP

class ToothpickApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KTP.openRootScope().installModules(toothpickModule)
    }
}