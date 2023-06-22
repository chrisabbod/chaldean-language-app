package com.example.chaldean_language_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chaldean_language_app.data.model.Lesson
import com.example.chaldean_language_app.ui.components.*

@Composable
fun LessonScreen(lesson: Lesson) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            LessonTitle(
                title = "Lesson ${lesson.lesson_number}: "
                        + lesson.lesson_title
            )
        }
        item {
            if (lesson.preliminary_notes.isNotEmpty()) {
                PreliminaryNotesSection(
                    notes = lesson.preliminary_notes
                )
            }
        }
        lesson.lesson_contents.forEach { lessonContent ->
            lessonContent.pronouns?.let {
                item { PronounsSection(it) }
            }
            lessonContent.verbs?.let {
                item { VerbsSection(it) }
                lessonContent.notes.let {
                    item { NotesSection(it) }
                }
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
                item { QuestionsSection(it) }
            }
        }
    }
}
