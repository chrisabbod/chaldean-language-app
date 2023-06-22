package com.example.chaldean_language_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chaldean_language_app.data.model.Lesson

@Composable
fun LessonListScreen(lessons: List<Lesson>) {
    LazyColumn {
        items(lessons.size) { lesson ->
            LessonRow(lesson = lessons[lesson])
        }
    }
}

@Composable
fun LessonRow(lesson: Lesson) {
    Card (
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Lesson #${lesson.lesson_number}: ${lesson.lesson_title}",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}