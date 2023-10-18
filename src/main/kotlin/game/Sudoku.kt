package game

import game.generator.generateDummyBoard

class Sudoku(difficulty: Difficulty, generator: (Difficulty) -> Pair<Board, Board>) {
    var board: Board
    private val solution: Board

    init {
        val (lBoard, lSolution) = generator(difficulty)
        board = lBoard
        solution = lSolution
    }

    fun play(line: Line, column: Column, value: Value): Board {
        // If this throws NullPointerException, it means that the solution to the board is not initialized properly.
        if (value != solution.getCell(line, column)!!.value) throw WrongValueException("Wrong value.")
        return board.also{ b -> b.setCell(line, column, value) }
    }
}