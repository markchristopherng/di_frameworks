package au.com.auspost.android.feature.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DaggerModule {

    @Provides
    @Singleton
    fun provideMesageData(): MessageData {
        return MessageData()
    }

    @Provides
    @Singleton
    fun provideTimeService(): TimeService {
        return TimeServiceImpl()
    }

    @Provides
    fun provideGreetingSersvice(): GreetingService {
        return GreetingServiceImpl(provideMesageData(), provideTimeService())
    }
}