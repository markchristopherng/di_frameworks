package au.com.auspost.android.feature.toothpick

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject

class MainActivity : AppCompatActivity() {

    private val greetingService: GreetingService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KTP.openRootScope().inject(this)

        val greetings = findViewById<TextView>(R.id.greetingsTextView)
        greetings.text = "${greetingService.greetings()}"
    }
}
