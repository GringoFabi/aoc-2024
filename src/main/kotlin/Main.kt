package gringo.fabi.aoc

import gringo.fabi.aoc.day_06.findPossibleObstructions
import gringo.fabi.aoc.day_06.readStartingPosition
import gringo.fabi.aoc.day_06.visitAllPossibleFields
import java.io.InputStream
import gringo.fabi.aoc.day_06.RESOURCE as Day_06_RESOURCE_1

fun main() {
    val (map, guard) = readResourceToStream(Day_06_RESOURCE_1).readStartingPosition()
    val visitedFields = guard.visitAllPossibleFields(map, mutableSetOf())
    println("Result: ${visitedFields.size}")

    val obstructions = readResourceToStream(Day_06_RESOURCE_1).readStartingPosition().findPossibleObstructions(visitedFields)
    println("Result: $obstructions")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()