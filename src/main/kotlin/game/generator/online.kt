package game.generator

import com.google.gson.Gson
import game.Board
import game.Difficulty
import game.toCellArray
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

data class GameDto(val value: Array<IntArray>, val solution: Array<IntArray>, val difficulty: String)
data class NewBoardDto(val grids: Array<GameDto>, val results: String, val message: String)
data class OnlineResponseDto(val newboard: NewBoardDto)

fun generateOnlineBoard(difficulty: Difficulty): Pair<Board, Board>  {
    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://sudoku-api.vercel.app/api/dosuku"))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    val onlineResponse = Gson().fromJson(response.body(), OnlineResponseDto::class.java)
    val grid = onlineResponse.newboard.grids[0]
    return Pair(
        grid.value.toBoard(),
        grid.solution.toBoard()
    )
}

fun Array<IntArray>.toBoard(): Board = Board.new(this.flatMap { it.toList() }.toIntArray().toCellArray())