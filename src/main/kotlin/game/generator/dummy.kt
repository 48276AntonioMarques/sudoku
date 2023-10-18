package game.generator

import game.Board
import game.Difficulty
import game.toCellArray

fun generateDummyBoard(difficulty: Difficulty): Pair<Board, Board> {
    return Pair(
        Board.new(
            intArrayOf(
                0,0,0,0,0,4,0,3,0,
                0,3,0,0,5,2,7,0,0,
                1,8,2,3,0,0,5,9,0,
                8,0,1,5,0,0,0,0,3,
                0,0,0,1,3,7,8,2,9,
                7,0,0,2,0,0,4,0,0,
                2,0,5,6,8,0,0,0,7,
                0,0,0,0,0,1,0,0,0,
                3,4,0,7,0,5,0,0,2
            ).toCellArray()
        ),
        Board.new(
            intArrayOf(
                5,7,9,8,1,4,2,3,6,
                4,3,6,9,5,2,7,1,8,
                1,8,2,3,7,6,5,9,4,
                8,2,1,5,4,9,6,7,3,
                6,5,4,1,3,7,8,2,9,
                7,9,3,2,6,8,4,5,1,
                2,1,5,6,8,3,9,4,7,
                9,6,7,4,2,1,3,8,5,
                3,4,8,7,9,5,1,6,2
            ).toCellArray()
        )
    )
}