package com.example.chaldean_language_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonScreen(lessonData: LessonData) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = lessonData.lessons[0].lesson_sections,
        state = pagerState
    ) { pageIndex ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
//            LessonTitle(title = lessonData.lessons[0].lesson_title)
            when (pageIndex) {
                0 -> LessonTitle(title = lessonData.lessons[0].lesson_title)
                1 -> PronounsSection(pronounSection = lessonData.lessons[0].lesson_contents[0].pronouns)
                2 -> VerbsSection(verbs = lessonData.lessons[0].lesson_contents[0].verbs)
                3 -> VocabularySection(vocabulary = lessonData.lessons[0].lesson_contents[0].vocabulary)
            }
        }
    }
}

@Composable
fun LessonTitle(title: String) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PronounsSection(pronounSection: PronounSection?) {
    pronounSection?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Singular Pronouns", style = MaterialTheme.typography.h6)
            it.singular?.forEach { pronoun ->
                Text(text = "${pronoun.pronoun} - ${pronoun.translation}")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Plural Pronouns", style = MaterialTheme.typography.h6)
            it.plural?.forEach { pronoun ->
                Text(text = "${pronoun.pronoun} - ${pronoun.translation}")
            }
        }
    }
}

@Composable
fun VerbsSection(verbs: List<Verb>?) {
    verbs?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            it.forEach { verb ->
                Text(
                    text = "Verb root: ${verb.verb_root} - Tense: ${verb.verb_tense}",
                    style = MaterialTheme.typography.h6
                )
                verb.conjugations.forEach { conjugation ->
                    Text(text = "Pronoun: ${conjugation.pronoun} - Conjugation: ${conjugation.conjugation} - Translation: ${conjugation.translation}")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun VocabularySection(vocabulary: List<Vocabulary>?) {
    vocabulary?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            it.forEach { word ->
                Text(
                    text = "Word: ${word.word} - Translation: ${word.translation}",
                    style = MaterialTheme.typography.h6
                )
                word.notes?.let { notes ->
                    Text(text = "Notes: $notes")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewLessonTitle() {
    LessonTitle(title = "Sample Lesson Title")
}