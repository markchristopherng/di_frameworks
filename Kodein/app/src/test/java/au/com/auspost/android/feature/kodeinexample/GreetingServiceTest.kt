package au.com.auspost.android.feature.kodeinexample

import org.junit.Test

import org.junit.Assert.assertEquals
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class GreetingServiceTest {

    @Test
    fun testGreetingInTheMorning() {

        val testContainer = Kodein {
            import(kodeinModule)
            bind<TimeService>(overrides = true) with singleton {
                object : TimeService {
                    override fun getHourOfDay(): Int = 9
                }
            }
        }

        val greetingService by testContainer.instance<GreetingService>()
        assertEquals("Good morning, welcome to Kodein", greetingService.greetings())
    }

    @Test
    fun testGreetingInTheEvening() {

        val testContainer = Kodein {
            import(kodeinModule)
            bind<TimeService>(overrides = true) with singleton {
                object : TimeService {
                    override fun getHourOfDay(): Int = 18
                }
            }
        }
        val greetingService by testContainer.instance<GreetingService>()
        assertEquals("Good evening, welcome to Kodein", greetingService.greetings())
    }
}
