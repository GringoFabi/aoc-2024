package gringo.fabi.aoc

import gringo.fabi.aoc.day_02.numberOfTolerantSafeReports
import gringo.fabi.aoc.day_02.toListOfReports
import java.io.InputStream
import gringo.fabi.aoc.day_02.RESOURCE as Day_02_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_02_RESOURCE_1).toListOfReports().numberOfTolerantSafeReports()
    println("Result: $result")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()