package au.com.auspost.android.feature.koin

import org.koin.dsl.module

val koinModule = module {
    single { MessageData() }
    single<TimeService> { TimeServiceImpl() }
    single<GreetingService> {
        GreetingServiceImpl(get(), get())
    }
}