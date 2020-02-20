package au.com.auspost.android.feature.dagger

import android.app.Application

class DaggerApplication : Application() {

    val appComponent: AppComponent by lazy {

        DaggerAppComponent.factory().create("welcome to Dagger")
    }
}