package au.com.auspost.android.feature.dagger

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GreetingServiceTest {

    private lateinit var greetingService: GreetingService

    @Mock
    lateinit var timeService: TimeService

    @Before
    fun setup() {
        greetingService = GreetingServiceImpl(MessageData("welcome to Dagger"), timeService)
    }

    @Test
    fun testGreetingInTheMorning() {
        whenever(timeService.getHourOfDay()).thenReturn(9)
        assertEquals("Good morning, welcome to Dagger", greetingService.greetings())
    }

    @Test
    fun testGreetingInTheEvening() {
        whenever(timeService.getHourOfDay()).thenReturn(18)
        assertEquals("Good evening, welcome to Dagger", greetingService.greetings())
    }
}
