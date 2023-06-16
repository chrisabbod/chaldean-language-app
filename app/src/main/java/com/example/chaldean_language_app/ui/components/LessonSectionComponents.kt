package com.example.chaldean_language_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chaldean_language_app.PronounSection
import com.example.chaldean_language_app.Verb
import com.example.chaldean_language_app.Vocabulary

@Composable
fun LessonTitle(title: String) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5
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