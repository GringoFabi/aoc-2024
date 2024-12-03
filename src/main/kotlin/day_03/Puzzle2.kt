package gringo.fabi.aoc.day_03

fun String.findFilteredMatchesAndMultiply(): Int = split("do()")
    .joinToString("") { it.substringBefore("don't") }.findMatchesAndMultiply()
