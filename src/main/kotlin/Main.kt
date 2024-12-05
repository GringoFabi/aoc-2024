package gringo.fabi.aoc

import day_05.foo
import gringo.fabi.aoc.day_05.readToLines
import gringo.fabi.aoc.day_05.splitAtEmptyRow
import java.io.InputStream
import gringo.fabi.aoc.day_05.RESOURCE as Day_05_RESOURCE_1

fun main() {
    val result = readResourceToStream(Day_05_RESOURCE_1).readToLines().splitAtEmptyRow().foo()
    println("Result: $result")
}

fun readResourceToStream(resource: String): InputStream = requireNotNull({}::class.java.classLoader.getResource(resource)).openStream()