package au.com.auspost.android.feature.toothpick

import toothpick.InjectConstructor

data class MessageData(val welcomeMessage: String = "welcome to Toothpick")

@InjectConstructor
class GreetingServiceImpl(private val messageData: MessageData, private val timeService: TimeService) :
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