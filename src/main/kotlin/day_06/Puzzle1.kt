package gringo.fabi.aoc.day_06

fun Map<Pair<Int, Int>, Char>.visitAllFields() = simulate().first.size

fun Guard.visitAllPossibleFields(map: Array<CharArray>, visited: MutableSet<Triple<Int, Int, Direction>>): MutableSet<Pair<Int, Int>> {
    val uniqueFields = mutableSetOf<Pair<Int, Int>>()
    uniqueFields.add(position)

    while (true) {
        val (x, y) = position
        uniqueFields.add(position)

        // Track position and direction
        if (!visited.add(Triple(x, y, direction))) {
            break // If revisiting a state, stop the simulation
        }

        val (newX, newY) = when (direction) {
            Direction.UP -> Pair(x, y - 1)
            Direction.DOWN -> Pair(x, y + 1)
            Direction.LEFT -> Pair(x - 1, y)
            Direction.RIGHT -> Pair(x + 1, y)
        }

        // Check bounds
        if (newX < 0 || newX >= map[0].size || newY < 0 || newY >= map.size) {
            break // Guard leaves the field
        }

        val c = map[newY][newX]
        if (c == '#') {
            turnRight()
            continue
        }

        position = Pair(newX, newY)
    }

    return uniqueFields
}
