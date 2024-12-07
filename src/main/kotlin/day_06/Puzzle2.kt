package gringo.fabi.aoc.day_06

fun Map<Pair<Int, Int>, Char>.checkForLoops(): Int =
    simulate().first.count { simulate(it).second }

fun Pair<Array<CharArray>, Guard>.findPossibleObstructions(visitedFields: MutableSet<Pair<Int, Int>>): Int {
    val (originalMap, originalGuard) = this
    var loopCount = 0

    visitedFields.forEach { obstruction ->
        val (x, y) = obstruction

        // The guard's starting position may not be obstructed
        if (obstruction == originalGuard.position) {
            return@forEach
        }

        // Create a deep copy of the map and the guard
        val mapCopy = originalMap.map { it.copyOf() }.toTypedArray()
        val guardCopy = originalGuard.copy()

        // Place the obstruction
        mapCopy[y][x] = '#'

        // Simulate the guard's movement with the new map
        val visited = mutableSetOf<Triple<Int, Int, Direction>>()
        val guardPositionHistory = guardCopy.visitAllPossibleFields(mapCopy, visited)

        // Check if there is a loop
        if (visited.contains(Triple(guardCopy.position.first, guardCopy.position.second, guardCopy.direction))) {
            loopCount++
        }
    }

    return loopCount
}

