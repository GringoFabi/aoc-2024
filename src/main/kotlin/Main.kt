package gringo.fabi.aoc

import gringo.fabi.aoc.day_03.findFilteredMatchesAndMultiply
import gringo.fabi.aoc.day_03.readAsString
import java.io.InputStream
import gringo.fabi.aoc.day_03.RESOURCE as Day_03_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_03_RESOURCE_1).readAsString().findFilteredMatchesAndMultiply()
    println("Result: $result")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()