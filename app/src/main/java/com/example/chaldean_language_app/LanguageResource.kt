package com.example.chaldean_language_app

/**
These classes mirror the structure of the language_lessons JSON file

Lesson represents the entire JSON file, which has preliminary notes, examples, and a list of lesson contents.
Example represents the example words and their translations provided at the start.
LessonContent represents individual lessons, each with its own number, title, set of pronouns, verbs, and vocabulary words.
Pronouns has a list for singular and plural pronouns.
Pronoun represents an individual pronoun and its translation.
Verb contains the root of the verb, its tense, and a list of conjugations.
Conjugation represents a verb conjugation for a specific pronoun and its translation.
Vocabulary represents a vocabulary word, its translation, and any notes associated with it.
 */

data class LanguageResource(
    val preliminary_notes: Map<String, String>,
    val examples: List<Example>,
    val lessons: List<Lesson>
)

data class Example(
    val word: String,
    val translation: String
)

data class Lesson(
    val lesson_number: Int,
    val lesson_title: String,
    val lesson_contents: List<LessonContent>
)

data class LessonContent(
    val vocabulary: List<Vocabulary>,
    val verbs: List<Verb>,
    val pronouns: Pronouns
)

data class Vocabulary(
    val word: String,
    val translation: String,
    val notes: String? = null
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

data class Pronouns(
    val singular: List<Pronoun>,
    val plural: List<Pronoun>
)

data class Pronoun(
    val pronoun: String,
    val translation: String
)


