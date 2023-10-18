package game.bot

import game.Cell
import game.Sudoku
import game.SudokuException
import ui.displayBoard

fun Bot.checkDuplicates(sudoku: Sudoku) {
    val internalBoard = MutableList(81) { i -> Possibility(i / 9, i % 9, sudoku.board.values.toMutableList()) }
    var iteration = 0
    var valuesFilled = 0
    while(!isSolved(sudoku)) {
        valuesFilled = 0
        for (i in sudoku.board.cellsRange) {
            for (j in sudoku.board.cellsRange) {
                val cell = sudoku.board.getLine(i)[j]
                if (cell == null) {
                    // If internalCell is null, that means that the cell is already filled, but we didn't notice.
                    val internalCell = internalBoard.find { p ->  p.line == i && p.column == j }
                    if (internalCell != null) {
                        // Check duplicates.
                        val checkCells = listOf(
                            getLine(sudoku, i),
                            getColumn(sudoku, j),
                            getSquare(sudoku, i, j)
                        ).flatten().distinct()

                        checkCells.forEach {
                            internalCell.values.remove(it?.value)
                            if (internalCell.values.size == 1 && sudoku.board.getCell(i, j) == null) {
                                sudoku.play(i, j, internalCell.values[0])
                                internalBoard.remove(internalCell)
                                valuesFilled++
                            }
                        }
                    }
                    else {
                        println("Error: internalCell is null.")
                    }
                }
            }
        }
        // If no values were filled, then we need to try your luck.
        if (valuesFilled == 0) {
            val testPossibility = getLessPossibilities(internalBoard)
            try {
                this.guesses++
                sudoku.play(testPossibility.line, testPossibility.column, testPossibility.values[0])
                internalBoard.remove(testPossibility)
            }
            catch (e: SudokuException) {
                // If we can't play this possibility, then we need to remove it from the list.
                testPossibility.values.remove(testPossibility.values[0])
                // Punish the bot for error.
                this.errors++
            }
        }
        print("\r${sudoku.board.cellsRange.sumOf { i -> sudoku.board.cellsRange.count { j -> sudoku.board.getLine(i)[j] != null } }} / 81")
        (0..iteration++ % 3).forEach { print(".") }
    }
    println()
}

fun isSolved(sudoku: Sudoku): Boolean {
    return sudoku.board.cellsRange.all { i ->
        sudoku.board.cellsRange.all { j ->
            sudoku.board.getLine(i)[j] != null
        }
    }
}

fun getLine(sudoku: Sudoku, i: Int) = sudoku.board.getLine(i).toList().filterNotNull()

fun getColumn(sudoku: Sudoku, j: Int) = sudoku.board.cellsRange.map { sudoku.board.getCell(it, j) }

fun getSquare(sudoku: Sudoku, i: Int, j: Int): List<Cell?> {
    val squareLine = i / 3 * 3
    val squareColumn = j / 3 * 3
    return (0..2).flatMap { k ->
        (0..2).map { l ->
            sudoku.board.getCell(squareLine + k, squareColumn + l)
        }
    }
}

fun getLessPossibilities(internalBoard: MutableList<Possibility>): Possibility {
    return internalBoard.reduce { acc, possibility ->
        if (acc.values.size <= possibility.values.size) acc else possibility
    }
}

