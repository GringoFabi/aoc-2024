package gringo.fabi.aoc.day_02

import java.io.InputStream

const val RESOURCE = "02_1_input.txt"

typealias Report = List<Int>

fun InputStream.toListOfReports(): List<Report> = bufferedReader().useLines { lines ->
    lines.map { line -> line.trim().split("\\s+".toRegex()).map { it.toInt() } }.toList()
}