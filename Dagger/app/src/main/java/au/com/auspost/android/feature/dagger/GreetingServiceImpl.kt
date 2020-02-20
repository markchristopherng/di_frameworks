package au.com.auspost.android.feature.dagger

import javax.inject.Inject
import javax.inject.Singleton

class MessageData {

    var welcomeMessage: String = ""

    @Inject constructor(welcomeMessage: String) {
        this.welcomeMessage = welcomeMessage
    }
}

@Singleton
class GreetingServiceImpl @Inject constructor(private val messageData: MessageData, private val timeService: TimeService) :
    GreetingService {

    override fun greetings(): String {

        val timeOfDay = when (timeService.getHourOfDay()) {
            in 7..11 -> "morning"
            in 17..23 -> "evening"
            else -> "day"
        }
        return "Good $timeOfDay, ${messageData.welcomeMessage}"
    }
}