package com.example.chaldean_language_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.chaldean_language_app.data.utils.Utils.loadJSONFromAsset
import com.example.chaldean_language_app.data.utils.Utils.parseJSON
import com.example.chaldean_language_app.navigation.LessonNavGraph
import com.example.chaldean_language_app.ui.screens.LessonListScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jsonString = loadJSONFromAsset(this, "language_lessons.json")
        val lessonData = parseJSON(jsonString)

        setContent {
            val navController = rememberNavController()
            val lessons = lessonData.lessons

            LessonNavGraph(navController, lessons)
        }
    }
}