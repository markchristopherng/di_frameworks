package au.com.auspost.android.feature.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DaggerModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}