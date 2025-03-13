//package jetbrains.kotlin.course.alias.team
//import org.springframework.stereotype.Service
//@Service
//class TeamService {
    //fun generateTeamsForOneRound(teamsNumber: Int): List<Team> = TODO("Not implemented yet")
//}

package jetbrains.kotlin.course.alias.team

//import necessary classes and annotations for reference to identifier classes
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    //a factory to generate unique IDs for teams
    val identifierFactory: IdentifierFactory = IdentifierFactory()

    //a companion object to store all teams in one place
    companion object {
        //a map to store teams, using their IDs as keys
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    //this method creates a list of teams for one round of the game.
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> { //the line that was here before implementation
        val teams = mutableListOf<Team>()  //creates an empty list to store the new teams

        //this is a loop to create the specified number of teams
        for (i in 1..teamsNumber) {
            //generates a unique ID for the team
            val teamId = identifierFactory.generateUniqueIdentifier()
            //creates a new team with the generated ID
            val team = Team(id = teamId)
            //adds the team to the list
            teams.add(team)
            //stores the team in the teamsStorage map for future reference
            teamsStorage[teamId] = team
        }

        return teams //returns the list of created teams
    }
}