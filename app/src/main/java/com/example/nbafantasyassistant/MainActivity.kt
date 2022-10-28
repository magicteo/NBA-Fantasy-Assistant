package com.example.nbafantasyassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById<TextView>(R.id.modifiable)
        button = findViewById(R.id.button)

        val url = "https://www.rotowire.com/basketball/injury-report.php"
        val doc = Jsoup.connect(url).get()
        val events = doc.select("h1.page-title__primary")

        button.setOnClickListener{
            textView.text = events.toString()
        }

    }
}