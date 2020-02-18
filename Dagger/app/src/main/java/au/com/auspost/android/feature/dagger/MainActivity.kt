package au.com.auspost.android.feature.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var greetingService: GreetingService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as DaggerApplication).appComponent.inject(this)

        val greetings = findViewById<TextView>(R.id.greetingsTextView)
        greetings.text = "${greetingService.greetings()}"
    }
}
