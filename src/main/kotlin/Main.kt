package gringo.fabi.aoc


import gringo.fabi.aoc.day_06.readStartingPosition
import gringo.fabi.aoc.day_06.visitAllFieldsAndCountUnique
import java.io.InputStream
import gringo.fabi.aoc.day_06.RESOURCE as Day_06_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_06_RESOURCE_1).readStartingPosition().visitAllFieldsAndCountUnique()
    println("Result: $result")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()