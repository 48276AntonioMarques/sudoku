import game.Difficulty
import game.Sudoku
import game.bot.Bot
import game.bot.bruteForce
import game.generator.generateOnlineBoard
import org.junit.jupiter.api.Test

class BruteForceTests {

    @Test
    fun `run bruteForce`() {
        val sudoku = Sudoku(Difficulty.MEDIUM, ::generateOnlineBoard)
        val bot = Bot()
        bot.start(sudoku, Bot::bruteForce)
    }
}