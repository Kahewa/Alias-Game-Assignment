
package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

// this is a value class to store a single word. It is optimized
// for performance and avoids unnecessary object creation.

@JvmInline
value class Word(val word: String)

//data class to store information about a card.
data class Card(
    val id: Identifier, //unique ID for the card
    val words: List<Word> //list of words on the card
)