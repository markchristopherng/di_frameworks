package au.com.auspost.android.feature.kodeinexample

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val kodeinModule = Kodein.Module(name = "appmodule") {
    bind() from singleton { MessageData() }
    bind<TimeService>() with singleton { TimeServiceImpl() }
    bind<GreetingService>() with singleton {
        GreetingServiceImpl(instance(), instance()) }
}