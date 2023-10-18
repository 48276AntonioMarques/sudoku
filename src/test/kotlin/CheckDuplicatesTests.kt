import game.Difficulty
import game.Sudoku
import game.bot.Bot
import game.bot.checkDuplicates
import game.generator.generateOnlineBoard
import org.junit.jupiter.api.Test

class CheckDuplicatesTests {

    @Test
    fun `run checkDuplicates`() {
        val sudoku = Sudoku(Difficulty.MEDIUM, ::generateOnlineBoard)
        val bot = Bot()
        bot.start(sudoku, Bot::checkDuplicates)
    }
}