package com.example.chaldean_language_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chaldean_language_app.ui.components.LessonTitle
import com.example.chaldean_language_app.ui.components.PronounsSection
import com.example.chaldean_language_app.ui.components.VerbsSection
import com.example.chaldean_language_app.ui.components.VocabularySection

@Composable
fun LessonListScreen(lessonData: LessonData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            LessonTitle(title = "Lesson ${lessonData.lessons[0].lesson_number}: "
                    + lessonData.lessons[0].lesson_title)
        }
        lessonData.lessons[0].lesson_contents.forEach { lessonContent ->
            lessonContent.pronouns?.let {
                item { PronounsSection(it) }
            }
            lessonContent.verbs?.let {
                item { VerbsSection(it) }
            }
            lessonContent.vocabulary?.let {
                item { VocabularySection(it) }
            }
        }
    }
}

