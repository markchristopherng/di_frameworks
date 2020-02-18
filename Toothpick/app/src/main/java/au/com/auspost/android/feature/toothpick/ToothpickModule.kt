package au.com.auspost.android.feature.toothpick

import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val toothpickModule = module {
        bind<GreetingService>().toClass<GreetingServiceImpl>().singleton()
        bind<TimeService>().toInstance(TimeServiceImpl())
        bind<MessageData>().toInstance(MessageData())
}