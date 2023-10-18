package game

class Board(val size: Int = 9) {
    private var board: Array<Cell?> = Array(81) { null }
        set(value) {
            if (value.size != 81) throw InvalidBoardSizeException("Invalid board size.")
            field = value
        }

    companion object {
        private fun _new(board: Board, cells: Array<Cell?>): Board = board.also { board.board = cells }
        fun new(cells: Array<Cell?>): Board = _new(Board(), cells)
    }
    fun new(cells: Array<Cell?>) = _new(this, cells)

    val cellsRange = 0..8
    val values = 1..9

    private fun checkRange(line: Line, column: Column) {
        if (line !in cellsRange) throw InvalidCellException("Invalid line.")
        if (column !in cellsRange) throw InvalidCellException("Invalid column.")
    }
    private fun checkRange(cell: Cell) = checkRange(cell.line, cell.column)

    private fun checkValue(cell: Cell, value: Value) {
        if (cell.value != 0) throw CellAlreadyFilledException("Cell already filled.")
        if (value !in values) throw InvalidValueException("Invalid value.")
    }
    private fun checkValue(line: Line, column: Column, value: Value) = getCell(line, column)?.let { checkValue(it, value) }

    fun getCell(line: Line, column: Column): Cell? {
        checkRange(line, column)
        return board[line * 9 + column]
    }
    fun getCell(cell: Cell) = getCell(cell.line, cell.column)

    fun setCell(line: Line, column: Column, value: Value): Cell {
        checkRange(line, column)
        checkValue(line, column, value)
        val cell = Cell(line, column, value)
        board[line * 9 + column] = cell
        return cell
    }

    fun setCell(cell: Cell, value: Value): Cell = setCell(cell.line, cell.column, value)

    fun getLine(line: Line): Array<Cell?> = cellsRange.map { column -> getCell(line, column) }.toTypedArray()
}
