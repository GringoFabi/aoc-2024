package gringo.fabi.aoc.day_04

private const val SEARCH_TERM = "XMAS"

private val directions = listOf(
    Pair(-1, 0),   // ↑
    Pair(1, 0),    // ↓
    Pair(0, -1),   // ←
    Pair(0, 1),    // →
    Pair(-1, -1),  // ↖
    Pair(-1, 1),   // ↗
    Pair(1, -1),   // ↙
    Pair(1, 1)     // ↘
)

fun Array<CharArray>.countOccurrences(): Int {
    var count = 0
    for (row in indices) {
        for (col in this[row].indices) {
            directions.forEach { dir -> if (searchFrom(row, col, dir)) count++ }
        }
    }
    return count
}

private fun Array<CharArray>.searchFrom(row: Int, col: Int, direction: Pair<Int, Int>): Boolean {
    var (r, c) = row to col
    for (i in SEARCH_TERM.indices) {
        if (!isValid(r, c) || this[r][c] != SEARCH_TERM[i]) return false
        r += direction.first
        c += direction.second
    }
    return true
}

private fun Array<CharArray>.isValid(x: Int, y: Int): Boolean =
    x in indices && y in this[x].indices