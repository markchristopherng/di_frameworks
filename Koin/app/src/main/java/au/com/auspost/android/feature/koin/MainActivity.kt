package au.com.auspost.android.feature.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val greetingService by inject<GreetingService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetings = findViewById<TextView>(R.id.greetingsTextView)
        greetings.text = "${greetingService.greetings()}"
    }
}
