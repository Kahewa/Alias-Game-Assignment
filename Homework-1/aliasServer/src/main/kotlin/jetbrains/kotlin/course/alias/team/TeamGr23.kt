package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
//imports the Identifier type from the jetbrains.kotlin.course.alias.util package


data class Team( //this is a data class to store information about a team.
    val id: Identifier, //unique ID for the team
    var points: Int = 0, //the team's points, starting at 0 by default
) {
    //this property creates a team name like "Team#1", "Team#2", etc.
    val name: String = "Team#${id + 1}"
}