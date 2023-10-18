import game.Difficulty
import game.Sudoku
import game.generator.generateOnlineBoard
import ui.Console

fun main() {
    val sudoku = Sudoku(Difficulty.MEDIUM, ::generateOnlineBoard)
    Console().start(sudoku)
}