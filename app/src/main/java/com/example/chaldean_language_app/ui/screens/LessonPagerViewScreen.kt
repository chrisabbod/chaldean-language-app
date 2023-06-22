package com.example.chaldean_language_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chaldean_language_app.data.model.LessonData
import com.example.chaldean_language_app.ui.components.LessonTitle
import com.example.chaldean_language_app.ui.components.PronounsSection
import com.example.chaldean_language_app.ui.components.VerbsSection
import com.example.chaldean_language_app.ui.components.VocabularySection

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonPagerViewScreen(lessonData: LessonData) {
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
            when (pageIndex) {
                0 -> LessonTitle(title = "Lesson ${lessonData.lessons[0].lesson_number}: "
                        + lessonData.lessons[0].lesson_title
                )
                1 -> PronounsSection(pronounSection = lessonData.lessons[0].lesson_contents[0].pronouns)
                2 -> VerbsSection(verbs = lessonData.lessons[0].lesson_contents[0].verbs)
                3 -> VocabularySection(vocabulary = lessonData.lessons[0].lesson_contents[0].vocabulary)
            }
        }
    }
}