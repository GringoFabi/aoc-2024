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

fun Map<Pair<Int, Int>, Char>.simulate(
    obstructionPosition: Pair<Int, Int>? = null,
): Pair<Set<Pair<Int, Int>>, Boolean> {
    var (guardPosition, guardDirection) = entries.first { it.value == '^' }
    var hasLoop = false
    val visited = mutableSetOf<Pair<Pair<Int, Int>, Char>>()

    while (true) {
        if (visited.contains(guardPosition to guardDirection)) {
            hasLoop = true
            break
        }

        visited.add(guardPosition to guardDirection)
        val targetPosition = guardPosition.nextPosition(guardDirection)

        when {
            this[targetPosition] == '#' || targetPosition == obstructionPosition -> guardDirection =
                requireNotNull(CHANGE_DIRECTION_MAP[guardDirection])

            // guard leaves the field
            this[targetPosition] == null -> break

            else -> guardPosition = targetPosition
        }
    }

    return visited.map { it.first }.toSet() to hasLoop
}

private val CHANGE_DIRECTION_MAP = mapOf(
    '^' to '>',
    '>' to 'v',
    'v' to '<',
    '<' to '^',
)

private fun Pair<Int, Int>.nextPosition(direction: Char): Pair<Int, Int> = when (direction) {
    '^' -> (first - 1) to second
    '>' -> first to second + 1
    'v' -> (first + 1) to second
    '<' -> first to second - 1
    else -> throw Exception("unknown guard direction $direction")
}