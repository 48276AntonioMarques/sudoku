import game.Difficulty
import game.Sudoku
import game.bot.Bot
import game.bot.bruteForce
import game.generator.generateDummyBoard
import game.generator.generateOnlineBoard
import org.junit.jupiter.api.Test
import java.lang.Exception
import kotlin.time.Duration

class BruteForceTests {

    @Test
    fun `run bruteForce`() {
        val sudoku = Sudoku(Difficulty.MEDIUM, ::generateOnlineBoard)
        val bot = Bot()
        bot.start(sudoku, Bot::bruteForce)
    }

    @Test
    fun `massive run bruteForce`() {
        var timing = Duration.ZERO
        var guessing = 0
        var missing = 0
        var exceptions = 0
        var repeat = 1_000
        while (repeat-- > 0) {
            try {
                val sudoku = Sudoku(Difficulty.MEDIUM, ::generateOnlineBoard)
                val bot = Bot()
                bot.start(sudoku, Bot::bruteForce)
                timing += bot.time
                guessing += bot.guesses
                missing += bot.errors
                Thread.sleep(100)
            }
            catch (e: Exception) {
                // If there's a network error, try again.
                exceptions++
                println("IllegalStateException: ${e.message}")
            }
            println("Remaining: $repeat")
        }
        println("Average time: ${timing / 1_000}ms")
        println("Average guesses: ${guessing / 1_000}")
        println("Average misses: ${missing / 1_000}")
        println("Exceptions: $exceptions")
    }

    @Test
    fun `massive run bruteForce with dummy`() {
        var timing = Duration.ZERO
        var guessing = 0
        var missing = 0
        var exceptions = 0
        var repeat = 1_000
        while (repeat-- > 0) {
            try {
                val sudoku = Sudoku(Difficulty.MEDIUM, ::generateDummyBoard)
                val bot = Bot()
                bot.start(sudoku, Bot::bruteForce)
                timing += bot.time
                guessing += bot.guesses
                missing += bot.errors
                Thread.sleep(100)
            }
            catch (e: Exception) {
                // If there's a network error, try again.
                exceptions++
                println("IllegalStateException: ${e.message}")
            }
            println("Remaining: $repeat")
        }
        println("Average time: ${timing / 1_000}ms")
        println("Average guesses: ${guessing / 1_000}")
        println("Average misses: ${missing / 1_000}")
        println("Exceptions: $exceptions")
    }
}