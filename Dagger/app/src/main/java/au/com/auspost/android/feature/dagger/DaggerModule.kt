package au.com.auspost.android.feature.dagger

import dagger.Binds
import dagger.Module

@Module
interface DaggerModule {

    @Binds
    fun provideTimeService(impl: TimeServiceImpl): TimeService

    @Binds
    fun provideGreetingSersvice(impl: GreetingServiceImpl): GreetingService
}