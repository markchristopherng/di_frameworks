package au.com.auspost.android.feature.koin

import org.junit.Test

import org.junit.Assert.assertEquals
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given

class GreetingServiceMockTest : KoinTest {

    private val greetingService: GreetingService by inject()

    @Test
    fun testGreetingInTheMorning() {
        startKoin { modules(koinModule) }
        declareMock<TimeService> {
            given(this.getHourOfDay()).willReturn(9)
        }
        assertEquals("Good morning, welcome to Koin", greetingService.greetings())
        stopKoin()
    }

    @Test
    fun testGreetingInTheEvening() {
        startKoin { modules(koinModule) }
        declareMock<TimeService> {
            given(this.getHourOfDay()).willReturn(17)
        }
        assertEquals("Good evening, welcome to Koin", greetingService.greetings())
        stopKoin()
    }
}
