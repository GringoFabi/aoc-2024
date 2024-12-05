package gringo.fabi.aoc.day_02

import java.io.InputStream

const val RESOURCE = "puzzles/02_1_input.txt"

typealias Report = List<Int>

fun InputStream.toListOfReports(): List<Report> = bufferedReader().useLines { lines ->
    lines.map { line -> line.trim().split("\\s+".toRegex()).map { it.toInt() } }.toList()
}

fun Report.isAscending(): Boolean = zipWithNext().all { (a, b) -> a < b }

fun Report.isDescending(): Boolean = zipWithNext().all { (a, b) -> a > b }

fun Report.order(): Int = when {
    isAscending() -> 1
    isDescending() -> -1
    else -> 0
}