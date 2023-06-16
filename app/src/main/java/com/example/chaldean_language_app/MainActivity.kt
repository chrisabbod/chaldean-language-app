package com.example.chaldean_language_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.chaldean_language_app.data.utils.Utils.loadJSONFromAsset
import com.example.chaldean_language_app.data.utils.Utils.parseJSON

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jsonString = loadJSONFromAsset(this, "language_lessons.json")
        val lessonData = parseJSON(jsonString)

        setContent {
            LessonListScreen(lessonData = lessonData)
        }
    }
}