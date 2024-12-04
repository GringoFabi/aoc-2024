package gringo.fabi.aoc.day_04

fun Array<CharArray>.countCrossings(): Int {
    var crossingCount = 0

    for (row in 1 until size - 1) {
        for (col in 1 until this[row].size - 1) {
            if (this[row][col] == 'A' && isCrossing(row, col)) {
                crossingCount++
            }
        }
    }

    return crossingCount
}

private fun Array<CharArray>.isCrossing(row: Int, col: Int): Boolean =
    isValidCrossing(row, col, Direction.LEFT) && isValidCrossing(row, col, Direction.RIGHT)

private fun Array<CharArray>.isValidCrossing(row: Int, col: Int, direction: Direction): Boolean {
    val topLeft = this[row - 1][col - 1]
    val bottomRight = this[row + 1][col + 1]
    val topRight = this[row - 1][col + 1]
    val bottomLeft = this[row + 1][col - 1]

    return when (direction) {
        Direction.LEFT -> (topLeft == 'M' && bottomRight == 'S') || (topLeft == 'S' && bottomRight == 'M')
        Direction.RIGHT -> (topRight == 'M' && bottomLeft == 'S') || (topRight == 'S' && bottomLeft == 'M')
    }
}

enum class Direction {
    LEFT, RIGHT
}
