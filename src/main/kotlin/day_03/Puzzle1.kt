package gringo.fabi.aoc.day_03

private val regex = Regex("""mul\(\s*\d{1,3}\s*,\s*\d{1,3}\s*\)""")

fun String.findMatchesAndMultiply(): Int = regex.findAll(this)
    .map { it.value }
    .map { it.drop(4).dropLast(1).split(",") }
    .sumOf { (a, b) -> a.trim().toInt() * b.trim().toInt() }
