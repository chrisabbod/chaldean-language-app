package com.example.chaldean_language_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.chaldean_language_app.Utils.loadJSONFromAsset
import com.example.chaldean_language_app.Utils.parseJSON

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = loadJSONFromAsset(this, "language_lessons.json")
        val lessonData = parseJSON(jsonString)

        val firstLessonTitle = lessonData.lessons[0].lesson_title

        setContent {
            LessonTitle(title = firstLessonTitle)
        }
    }
}