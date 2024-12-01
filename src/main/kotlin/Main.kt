package gringo.fabi.aoc

import gringo.fabi.aoc.day_01.absoluteDifference
import gringo.fabi.aoc.day_01.toPairOfLists
import java.io.InputStream
import gringo.fabi.aoc.day_01.RESOURCE as Day_01_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_01_RESOURCE_1).toPairOfLists().absoluteDifference()
    println(result)
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()