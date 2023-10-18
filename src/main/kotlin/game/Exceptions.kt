package game

open class SudokuException(message: String) : Exception(message)

class InvalidBoardSizeException(message: String) : SudokuException(message)

class InvalidCellException(message: String) : SudokuException(message)
class InvalidValueException(message: String) : SudokuException(message)
class WrongValueException(message: String) : SudokuException(message)
class CellAlreadyFilledException(message: String) : SudokuException(message)