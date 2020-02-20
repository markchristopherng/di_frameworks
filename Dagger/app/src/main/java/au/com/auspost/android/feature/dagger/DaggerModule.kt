package au.com.auspost.android.feature.dagger

import dagger.Binds
import dagger.Module

@Module
abstract class DaggerModule {

    @Binds
    abstract fun provideTimeService(impl: TimeServiceImpl): TimeService

    @Binds
    abstract fun provideGreetingSersvice(impl: GreetingServiceImpl): GreetingService
}