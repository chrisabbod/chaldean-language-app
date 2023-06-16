package com.example.chaldean_language_app

data class LessonData(
    val lessons: List<Lesson>
)

data class Lesson(
    val lesson_number: Int,
    val lesson_title: String,
    val lesson_sections: Int,
    val lesson_contents: List<LessonContent>
)

data class LessonContent(
    val pronouns: PronounSection?,
    val verbs: List<Verb>?,
    val vocabulary: List<Vocabulary>?
)

data class PronounSection(
    val singular: List<Pronoun>?,
    val plural: List<Pronoun>?
)

data class Pronoun(
    val pronoun: String,
    val translation: String
)

data class Verb(
    val verb_root: String,
    val verb_tense: String,
    val conjugations: List<Conjugation>
)

data class Conjugation(
    val pronoun: String,
    val conjugation: String,
    val translation: String
)

data class Vocabulary(
    val word: String,
    val translation: String,
    val notes: String?
)