package game

fun IntArray.toCellArray() = this.mapIndexed{ index, value ->
    if (value == 0) return@mapIndexed null
    Cell(index % 9, index * 9, value)
}.toTypedArray<Cell?>()