package game.bot

import game.Column
import game.Line
import game.Value

data class Possibility(val line: Line, val column: Column, val values: MutableList<Value>)