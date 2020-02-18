package au.com.auspost.android.feature.toothpick

import org.junit.Assert.assertEquals
import org.junit.Test
import toothpick.Toothpick
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import javax.inject.Inject

class GreetingServiceFakeTest {

    @Inject
    lateinit var greetingService: GreetingService

    @Test
    fun testGreetingInTheMorning() {

        val testModule = module {
            bind<TimeService>().toInstance(object : TimeService {
                override fun getHourOfDay(): Int = 9
            })
        }
        KTP.openRootScope().installTestModules(toothpickModule, testModule).inject(this)
        assertEquals("Good morning, welcome to Toothpick", greetingService.greetings())
        Toothpick.reset()
    }

    @Test
    fun testGreetingInTheEvening() {
        val testModule = module {
            bind<TimeService>().toInstance(object : TimeService {
                override fun getHourOfDay(): Int = 18
            })
        }
        KTP.openRootScope().installTestModules(toothpickModule, testModule).inject(this)
        assertEquals("Good evening, welcome to Toothpick", greetingService.greetings())
        Toothpick.reset()
    }
}
