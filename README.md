# Contents
- [Game](https://github.com/48276AntonioMarques/sudoku#Game)
  - [Rules](https://github.com/48276AntonioMarques/sudoku#Rules)
- Algortims
   - [Algorithms Implementation](https://github.com/48276AntonioMarques/sudoku#Game)
     - [Brute Force](https://github.com/48276AntonioMarques/sudoku#Game)
     - [Check Single Option](https://github.com/48276AntonioMarques/sudoku#Game)
   - [Algorithms Performance](https://github.com/48276AntonioMarques/sudoku#Game)
     - [Brute Force](https://github.com/48276AntonioMarques/sudoku#Game)
     - [Check Single Option](https://github.com/48276AntonioMarques/sudoku#Game)
# Game
This documet is WIP. (Testing missing)
## Rules
Sudoku is a game played by inserting numbers (values) from 1 to 9 into each empty cell on a 9 by 9 grid, composed by 3 by 3 subgrids (squares).
The game starts with some of the cells pre-filled soo that the numbers of the empty cells can be deducted.
Each row, column or square can only contain one of each of the numbers from 1 to 9.

# Algorithms Implementation

## Brute Force
 The first algorithm simple brute forces all possible values in every empty cell (in order, left to right and top to bottom).
 - When the game flags it as wrong it tries other value.
 - If the game allows the number to be palced therefore being right the algorithm moves on.

## Check Single Option
 This algorithm, in the same order as the one before, will determine which values can be introduced into the cell in test.
 To do that it will check what values aren't in it's row, column or square.
 Opon doing soo on the case on having only one possiblity it wiill play that value.
 If after a full swipe on the board no cell is populated it will make an "educated guess" with the following rules:
 - The guess will be on the cell with less values possible.
 - The value to be guessed will be the lowest within the values possible for that cell (wich are calculated by the step before).

# Algortihms Performance
 In the implementation of this project there were 3 main performance indicators:
 - Time (ms)
 - Errors
 - Guesses
All the values presented are suggestive since they can vary based on multiple external factors.
But the scale of this values still gives an inpression of the performace expected.
For the following calculations was used a population of 1.000 tries.
## Brute Force
- Using [dummyGenerator](https://github.com/48276AntonioMarques/sudoku/blob/main/src/main/kotlin/game/generator/dummy.kt)
 Total time: 1m50s
 Avg. time: 2.63ms
 Guesses: 405
 Errors: 360
- Using [onlineGenerator](https://github.com/48276AntonioMarques/sudoku/blob/main/src/main/kotlin/game/generator/online.kt)
 Total time: 11m23s
 Avg. time: 2.69ms
 Avg. Guesses: 464
 Avg. Errors: 412
## Check Single Option
- Using [dummyGenerator](https://github.com/48276AntonioMarques/sudoku/blob/main/src/main/kotlin/game/generator/dummy.kt)
 Total time: 1m49s
 Avg. time: 1ms
 Guesses: 5
 Errors: 0
- Using [onlineGenerator](https://github.com/48276AntonioMarques/sudoku/blob/main/src/main/kotlin/game/generator/online.kt)
 Total time: 10m45s
 Avg. time: 2.17ms
 Avg. Guesses: 9
 Avg. Errors: 0

 On the Check Single Option algorithm is important to need that sometimes the alogrithm makes mistakes (3 maybe more)
 but since we are averegaging out the values this indicates that most the time the game ends without any mistake.
