package gringo.fabi.aoc.day_01

fun Pair<List<Int>, List<Int>>.similarityScore(): Int =
    first.sumOf { value ->  value * second.count { value == it } }
