//package jetbrains.kotlin.course.alias.card
//import org.springframework.stereotype.Service
//@Service
//class CardService {
    //private fun generateCards(): List<Card> = TODO("Not implemented yet")
   // private fun List<String>.toWords(): List<Word> = TODO("Not implemented yet")
   // fun getCardByIndex(index: Int): Card = TODO("Not implemented yet")
//}



package jetbrains.kotlin.course.alias.card
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service


@Service
class CardService {
    //a factory to generate unique IDs for cards
    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    //a list of cards, initialized by calling generateCards()
    private val cards: List<Card> = generateCards()

    // Companion object to store constants and shared properties
    companion object {
        //number of words per card
        const val WORDS_IN_CARD: Int = 4

        //predefined list of words (made up to fit 5 cards)
        val words: List<String> = listOf(
            "Apple", "Banana", "Orange", "Grape", "Salad", "Boerewors", "Braai", "Burger", "Matthew",
            "Mark", "Luke", "John", "Android", "Apple", "Linux", "Windows", "Pink",
            "Blue", "Red", "Purple"
        )

        //number of cards based on the number of words and WORDS_IN_CARD
        val cardsAmount: Int = words.size / WORDS_IN_CARD
    }

    //extension function to convert List<String> to List<Word>
    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    //function to generate cards
    private fun generateCards(): List<Card> {
        //shuffles the words list
        val shuffledWords = words.shuffled()

        //splits the shuffled words into chunks of WORDS_IN_CARD words
        val wordChunks = shuffledWords.chunked(WORDS_IN_CARD)

        //takes only the first cardsAmount chunks
        val selectedChunks = wordChunks.take(cardsAmount)

        //creates a card for each chunk
        return selectedChunks.map { chunk ->
            Card(
                id = identifierFactory.generateUniqueIdentifier(),
                words = chunk.toWords()
            )
        }
    }

    //function to get a card by index
    fun getCardByIndex(index: Int): Card {
        //checks if the index is valid
        if (index < 0 || index >= cards.size) {
            throw CustomIllegalArgumentException("Invalid card index: $index")
        }
        return cards[index]
    }
}

//custom exception class (created because the argument is not part of libraries, so it was
// underlined red and the quick fix suggested i create a class for it.)
class CustomIllegalArgumentException(message: String) : Throwable(message)


