package au.com.auspost.android.feature.dagger

import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeServiceImpl @Inject constructor() : TimeService {

    override fun getHourOfDay(): Int {
        val cal = Calendar.getInstance()
        return cal.get(Calendar.HOUR_OF_DAY)
    }
}