package au.com.auspost.android.feature.toothpick

import android.os.Build
import android.widget.TextView
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import toothpick.Toothpick
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class GreetingServiceRoboTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var timeService: TimeService

    @Test
    fun testGreetingInTheMorning() {
        val testModule = module {
            bind<TimeService>().toInstance(object : TimeService {
                override fun getHourOfDay(): Int = 9
            })
        }
        KTP.openRootScope().installTestModules(testModule)
        val controller = Robolectric.buildActivity(MainActivity::class.java).setup()
        val textView = controller.get().findViewById<TextView>(R.id.greetingsTextView)
        Assert.assertEquals("Good morning, welcome to Toothpick", textView.text)
        Toothpick.reset()
    }

    @Test
    fun testGreetingInTheEvening() {
        val testModule = module {
            bind<TimeService>().toInstance(timeService)
        }
        whenever(timeService.getHourOfDay()).thenReturn(18)
        KTP.openRootScope().installTestModules(testModule)
        val controller = Robolectric.buildActivity(MainActivity::class.java).setup()
        val textView = controller.get().findViewById<TextView>(R.id.greetingsTextView)
        Assert.assertEquals("Good evening, welcome to Toothpick", textView.text)
        Toothpick.reset()
    }
}