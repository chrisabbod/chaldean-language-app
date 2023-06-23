package com.example.chaldean_language_app.data.model

data class LessonData(
    val lessons: List<Lesson>
)

data class Lesson(
    val lesson_number: Int,
    val lesson_title: String,
    val lesson_sections: Int,
    val review: String?,
    val preliminary_notes: String?,
    val lesson_contents: List<LessonContent>
)

data class LessonContent(
    val pronouns: Pronouns?,
    val verbs: List<Verb>?,
    val vocabulary: Vocabulary?,
    val numbers: Numbers?,
    val negatives: Negatives?,
    val questions: List<Question>?,
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
    val notes: String?,
    val words: List<Words>?
)

data class Words(
    val word: String,
    val translation: String,
)

data class Numbers(
    val notes: String?,
    val number: List<Number>?
)

data class Number(
    val gender: String,
    val numeral: String,
    val translation: String,
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

data class Question(
    val sentence: String,
    val translation: String,
    val notes: String?
)