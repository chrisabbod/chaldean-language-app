package com.example.chaldean_language_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chaldean_language_app.data.model.*

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
fun ReviewSection(review: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Review",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = review)
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun PreliminaryNotesSection(notes: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Preliminary Notes",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = notes)
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun NotesSection(notes: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Notes",
            style = MaterialTheme.typography.h5
        )
        Text(text = notes)
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun PronounsSection(pronounSection: Pronouns?) {
    pronounSection?.let {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Pronouns",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Singular Pronouns", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            it.singular?.forEach { pronoun ->
                Text(text = "${pronoun.translation} - ${pronoun.pronoun}")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Plural Pronouns", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            it.plural?.forEach { pronoun ->
                Text(text = "${pronoun.translation} - ${pronoun.pronoun}")
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun VerbsSection(verbs: List<Verb>?) {
    verbs?.let {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val groupedVerbs = it.groupBy { verb -> verb.verb_tense }

            Text(
                text = "Verbs",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            groupedVerbs.forEach { (_, verbList) ->
                verbList.forEach { verb ->
                    Text(
                        text = "VERB: ${verb.verb}\nROOT: ${verb.verb_root}\nTENSE: ${verb.verb_tense}",
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    verb.conjugations.forEach { conjugation ->
                        Text(text = "${conjugation.translation}: ${conjugation.pronoun} ${conjugation.conjugation}")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    if (verb.notes?.isNotEmpty() == true) {
                        Text(text = verb.notes)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}


@Composable
fun VocabularySection(vocabulary: List<Vocabulary>?) {
    vocabulary?.let {
        Column(
            modifier = Modifier.padding(16.dp),
            Arrangement.Center
        ) {
            Text(
                text = "Vocabulary",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Notes: ${vocabulary[0].notes}")
            Spacer(modifier = Modifier.height(4.dp))
            it.forEach { word ->
                Text(text = "${word.translation}: ${word.word}")
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun NumbersSection(numbers: List<Numbers>?) {
    numbers?.let {
        Column(
            modifier = Modifier.padding(16.dp),
            Arrangement.Center
        ) {
            Text(
                text = "Numbers",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Feminine",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            it.forEach { it ->
                if (it.gender == "Feminine") {
                    Text(text = "${it.number}: ${it.translation}")
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Masculine",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            it.forEach { it ->
                if (it.gender == "Masculine") {
                    Text(text = "${it.number}: ${it.translation}")
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun NegativesSection(negatives: Negatives?) {
    negatives?.let {
        Column(
            modifier = Modifier.padding(16.dp),
            Arrangement.Center
        ) {
            Text(
                text = "Negatives",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Examples",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))

            it.examples?.forEach { it ->
                Text(text = "${it.sentence}: ${it.translation}")
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Composable
fun QuestionsSection(questions: List<Questions>?) {
    questions?.let {
        Column(
            modifier = Modifier.padding(16.dp),
            Arrangement.Center
        ) {
            Text(
                text = "Questions",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Examples",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            it.forEach {it
               Text(text = "${it.sentence}: ${it.translation}")
            }
        }
    }
    Divider(color = Color.Gray, thickness = 0.5.dp)
}

@Preview
@Composable
fun PreviewLessonTitle() {
    LessonTitle(title = "Sample Lesson Title")
}