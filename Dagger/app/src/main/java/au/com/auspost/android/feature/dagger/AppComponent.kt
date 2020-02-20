package au.com.auspost.android.feature.dagger

import dagger.Component
import javax.inject.Singleton
import dagger.BindsInstance

@Singleton
@Component(modules = [DaggerModule::class])
interface AppComponent {

    fun getMessageData(): MessageData

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance welcomeMessage: String): AppComponent
    }
}