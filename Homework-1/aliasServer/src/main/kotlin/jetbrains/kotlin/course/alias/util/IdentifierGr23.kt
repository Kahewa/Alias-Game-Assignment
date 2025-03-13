package jetbrains.kotlin.course.alias.util

typealias Identifier = Int
//creates a shortcut for the type "Int" and call it "identifier."
//makes it easier to understand that we're working with IDs.

class IdentifierFactory { //his class is like a machine that creates unique ID numbers.
    var counter: Int = 0 //a counter keeps track of the last number used. It starts at 0.
        private set //this means only the class itself can change the counter.
    fun generateUniqueIdentifier(): Identifier {  //this function creates a new unique ID.
        return ++counter //increases the counter by 1 and returns the new number.
    }
}

fun uniqueIdentifier(factory: IdentifierFactory): Identifier { // uses the IdentifierFactory to get a new unique ID.
    return factory.generateUniqueIdentifier() //asks the factory to generate and return a new ID.
}