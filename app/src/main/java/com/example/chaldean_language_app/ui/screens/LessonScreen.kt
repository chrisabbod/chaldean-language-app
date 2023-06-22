package com.example.chaldean_language_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chaldean_language_app.data.model.LessonData
import com.example.chaldean_language_app.ui.components.*

@Composable
fun LessonScreen(lessonData: LessonData) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            LessonTitle(
                title = "Lesson ${lessonData.lessons[0].lesson_number}: "
                        + lessonData.lessons[0].lesson_title
            )
        }
        item {
            if (lessonData.lessons[0].preliminary_notes.isNotEmpty()) {
                PreliminaryNotesSection(
                    notes = lessonData.lessons[0].preliminary_notes
                )
            }

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
            lessonContent.numbers?.let {
                item { NumbersSection(it) }
            }
            lessonContent.negatives?.let {
                item { NegativesSection(it) }
            }
            lessonContent.questions?.let {
                item { QuestionsSection(it)}
            }
        }
    }
}

