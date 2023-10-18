package game.bot

import game.Sudoku
import ui.displayBoard
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class Bot {

    var guesses = 0
    var errors = 0

    @OptIn(ExperimentalTime::class)
    fun start(sudoku: Sudoku, solve: Bot.(Sudoku) -> Unit) {
        println("Displaying board...")
        displayBoard(sudoku.board)
        println("Solving...")
        val time = measureTime { this.solve(sudoku) }
        displayBoard(sudoku.board)
        println("Time: ${time.inWholeMilliseconds}ms Guesses: ${this.guesses} Errors: ${this.errors}")
    }

}