package com.example.chaldean_language_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chaldean_language_app.data.model.Lesson
import com.example.chaldean_language_app.data.model.LessonData
import com.example.chaldean_language_app.ui.screens.LessonListScreen
import com.example.chaldean_language_app.ui.screens.LessonScreen

@Composable
fun LessonNavGraph(
    navController: NavHostController,
    lessons: List<Lesson>
) {
    NavHost(navController = navController, startDestination = "lessonListScreen") {
        composable("lessonListScreen") {
            LessonListScreen(lessons, navController)
        }
        composable("lessonScreen/{lesson_number}") { backStackEntry ->
            //Retrieve the lesson_number from the current route
            val lessonNumber = backStackEntry.arguments?.getString("lesson_number")?.toIntOrNull()

            //Find the corresponding lesson from the lesson list
            val lesson = lessons.find { it.lesson_number == lessonNumber }

            //If a lesson is found show the LessonScreen. Otherwise navigate back.
            if (lesson != null) {
                LessonScreen(lesson = lesson)
            } else {
                //Navigate back if no matching lesson is found
                navController.popBackStack()
            }
        }
    }
}