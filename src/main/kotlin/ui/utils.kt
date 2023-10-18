package ui

import game.Board

fun displayBoard(board: Board) {
    println(" ┌───────┬───────┬───────┐")
    for (i in board.cellsRange) {
        print(" |")
        val line = board.getLine(i)
        for (j in board.cellsRange) {
            val cell = line[j]
            if (cell == null) print("  ")
            else print(" ${cell.value}")
            if (j % 3 == 2) print(" │")
        }
        println()
        if (i % 3 == 2 && i < board.cellsRange.last) println(" ├───────┼───────┼───────┤")
    }
    println(" └───────┴───────┴───────┘")
    println("  1 2 3   4 5 6   7 8 9") // This is meant to vanish once the number is completed.
}