package gringo.fabi.aoc.day_06

import java.io.InputStream

const val RESOURCE = "06_1_input.txt"

fun InputStream.readStartingPosition(): Pair<Array<CharArray>, Guard> {
    val guard = Guard(Pair(0, 0), Direction.UP)
    var y = 0

    return Pair(bufferedReader().readLines().map { line ->
        y++
        line.toCharArray().also {
            when {
                it.contains('^') -> guard.apply {
                    position = Pair(it.indexOf('^'), y)
                    direction = Direction.UP
                }

                it.contains('v') -> guard.apply {
                    position = Pair(it.indexOf('v'), y)
                    direction = Direction.DOWN
                }

                it.contains('<') -> guard.apply {
                    position = Pair(it.indexOf('<'), y)
                    direction = Direction.LEFT
                }

                it.contains('>') -> guard.apply {
                    position = Pair(it.indexOf('>'), y)
                    direction = Direction.RIGHT
                }
            }
        }
    }.toTypedArray<CharArray>(), guard)
}

data class Guard(
    var position: Pair<Int, Int>,
    var direction: Direction
) {
    fun turnRight() {
        direction = when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
        }
    }
}

enum class Direction(val char: Char) {
    UP('^'), DOWN('v'), LEFT('<'), RIGHT('>')
}