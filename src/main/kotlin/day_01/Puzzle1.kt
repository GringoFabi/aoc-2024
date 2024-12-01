package gringo.fabi.aoc.day_01

import kotlin.math.abs

fun Pair<List<Int>, List<Int>>.absoluteDifference(): Int = first.zip(second).sumOf { (a, b) -> abs(a - b) }
