//package jetbrains.kotlin.course.alias.results

//import org.springframework.stereotype.Service

//@Service
//class GameResultsService {
 //   fun saveGameResults(result: GameResult): Unit = TODO("Not implemented yet")

  //  fun getAllGameResults(): List<GameResult> = TODO("Not implemented yet")
//}

package jetbrains.kotlin.course.alias.results
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

// Type alias for GameResult (a list of teams)
typealias GameResult = List<Team>

@Service
class GameResultsService {
    // Companion object to store game history
    companion object {
        // Mutable list to store game results
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    // Function to save game results
    fun saveGameResults(result: GameResult) {
        // Check if the result is not empty
        require(result.isNotEmpty()) { "Game result cannot be empty." }

        // Check if all team IDs in the result are valid (exist in TeamService.teamsStorage)
        val invalidTeams = result.filter { team ->
            team.id !in TeamService.teamsStorage.keys
        }
        require(invalidTeams.isEmpty()) {
            "Invalid teams found in the result: ${invalidTeams.joinToString { it.name }}"
        }

        // Add the result to the game history
        gameHistory.add(result)
    }

    // Function to get all game results in reversed order
    fun getAllGameResults(): List<GameResult> {
        return gameHistory.reversed()
    }
}
