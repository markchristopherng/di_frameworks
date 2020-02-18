package au.com.auspost.android.feature.toothpick

import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import toothpick.testing.ToothPickRule
import javax.inject.Inject

@RunWith(MockitoJUnitRunner::class)
class GreetingServiceMockTest {

    @get:Rule
    var toothPickRule = ToothPickRule(this, "scope")

    @Inject
    lateinit var greetingService: GreetingService

    @Mock
    lateinit var timeService: TimeService

    @Before
    fun setup() = toothPickRule.scope.installModules(toothpickModule).inject(this)

    @Test
    fun testGreetingInTheMorning() {
        whenever(timeService.getHourOfDay()).thenReturn(9)
        assertEquals("Good morning, welcome to Toothpick", greetingService.greetings())
    }

    @Test
    fun testGreetingInTheEvening() {
        whenever(timeService.getHourOfDay()).thenReturn(18)
        assertEquals("Good evening, welcome to Toothpick", greetingService.greetings())
    }
}
