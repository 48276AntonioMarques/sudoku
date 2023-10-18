package ui

import game.Sudoku
import game.SudokuException

class Console {
    fun start(sudoku: Sudoku) {
        println("Welcome to Sudoku!")
        displayBoard(sudoku.board)
        println("Type 'help' for a list of commands.")
        while (true) {
            print("> ")
            when (readln()) {
                "help" -> println("Commands: help, exit, play, display")
                "exit" -> return
                "display" -> displayBoard(sudoku.board)
                "play" -> {
                    print("Line: ")
                    val line = readln().toInt()
                    print("Column: ")
                    val column = readln().toInt()
                    print("Value: ")
                    val value = readln().toInt()
                    try {
                        val newBoard = sudoku.play(line, column, value)
                        displayBoard(newBoard)
                    }
                    catch (se: SudokuException) {
                        println(se.message)
                    }
                }
                else -> println("Unknown command.")
            }
        }
    }
}