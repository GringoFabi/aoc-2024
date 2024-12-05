package gringo.fabi.aoc.day_05

import java.io.InputStream

const val RESOURCE = "05_1_input.txt"

fun InputStream.readToLines() = bufferedReader().readLines()

fun List<String>.splitAtEmptyRow(): Pair<List<String>, List<String>> {
    val index = indexOf("")
    return take(index) to drop(index + 1)
}

fun List<String>.readRules(): Set<Pair<Int, Int>> = this.map { rule ->
    rule.split("|").let { it[0].toInt() to it[1].toInt() }
}.toSet()

fun List<String>.toIntArrayList(): List<List<Int>> = this
    .map { row -> row.split(",").map { it.toInt() } }