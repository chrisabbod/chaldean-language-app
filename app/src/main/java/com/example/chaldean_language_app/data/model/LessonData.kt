package com.example.chaldean_language_app.data.model

data class LessonData(
    val lessons: List<Lesson>
)

data class Lesson(
    val lesson_number: Int,
    val lesson_title: String,
    val lesson_sections: Int,
    val review: String?,
    val preliminary_notes: String,
    val lesson_contents: List<LessonContent>
)

data class LessonContent(
    val pronouns: Pronouns?,
    val verbs: List<Verb>?,
    val vocabulary: List<Vocabulary>?,
    val numbers: List<Numbers>?,
    val negatives: Negatives?,
    val questions: List<Questions>?,
)

data class Pronouns(
    val notes: String?,
    val singular: List<Pronoun>?,
    val plural: List<Pronoun>?
)

data class Pronoun(
    val pronoun: String,
    val translation: String,
    val notes: String?
)

data class Verb(
    val verb: String,
    val verb_root: String,
    val verb_tense: String,
    val notes: String?,
    val conjugations: List<Conjugation>
)

data class Conjugation(
    val pronoun: String,
    val conjugation: String,
    val translation: String,
    val notes: String?
)

data class Vocabulary(
    val word: String,
    val translation: String,
    val notes: String?
)

data class Numbers(
    val gender: String,
    val number: String,
    val translation: String,
    val notes: String?
)

data class Negatives(
    val notes: String?,
    val examples: List<Examples>?
)

data class Examples(
    val sentence: String,
    val translation: String,
    val notes: String?
)

data class Questions(
    val sentence: String,
    val translation: String,
    val notes: String?
)