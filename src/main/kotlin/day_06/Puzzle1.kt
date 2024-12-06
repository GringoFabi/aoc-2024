package gringo.fabi.aoc.day_06

fun Pair<Array<CharArray>, Guard>.visitAllFieldsAndCountUnique(): Int {
    val (map, guard) = this
    val uniqueFields = mutableSetOf<Pair<Int, Int>>()
    uniqueFields.add(guard.position)

    while (true) {
        val (x, y) = guard.position.first to guard.position.second
        uniqueFields.add(guard.position)

        val (newX, newY) = when (guard.direction) {
            Direction.UP -> Pair(x, y - 1)
            Direction.DOWN -> Pair(x, y + 1)
            Direction.LEFT -> Pair(x - 1, y)
            Direction.RIGHT -> Pair(x + 1, y)
        }

        if (newX < 0 || newX >= map[0].size || newY < 0 || newY >= map.size) {
            break
        }

        if (map[newY][newX] == '#') {
            guard.turnRight()
            continue
        }

        guard.position = Pair(newX, newY)
    }

    return uniqueFields.size
}