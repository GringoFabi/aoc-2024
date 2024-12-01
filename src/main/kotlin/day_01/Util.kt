package gringo.fabi.aoc.day_01

import java.io.InputStream

const val RESOURCE = "01_1_input.txt"

fun InputStream.toPairOfLists(): Pair<List<Int>, List<Int>> = bufferedReader().useLines { lines ->
    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()
    lines.forEach { line ->
        val (a, b) = line.trim().split("\\s+".toRegex()).map { it.toInt() }
        first.add(a)
        second.add(b)
    }
    Pair(first.sorted(), second.sorted())
}
