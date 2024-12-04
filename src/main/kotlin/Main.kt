package gringo.fabi.aoc

import gringo.fabi.aoc.day_04.countCrossings
import gringo.fabi.aoc.day_04.readToCharacterMatrix
import java.io.InputStream
import gringo.fabi.aoc.day_04.RESOURCE as Day_04_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_04_RESOURCE_1).readToCharacterMatrix().countCrossings()
    println("Result: $result")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()