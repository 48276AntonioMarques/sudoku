package game.bot

import game.Sudoku
import game.SudokuException

fun Bot.bruteForce(sudoku: Sudoku) {
    for (i in sudoku.board.cellsRange) {
        for (j in sudoku.board.cellsRange) {
            val cell = sudoku.board.getLine(i)[j]
            if (cell == null) {
                for (k in sudoku.board.values) {
                    try {
                        sudoku.play(i, j, k)
                    } catch (e: SudokuException) {
                        // Punish the bot for error.
                        this.errors++
                    }
                }
            }
        }
    }
}