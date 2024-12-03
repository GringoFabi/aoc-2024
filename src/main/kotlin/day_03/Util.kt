package gringo.fabi.aoc.day_03

import java.io.InputStream

const val RESOURCE = "03_1_input.txt"

fun InputStream.readAsString(): String = bufferedReader().readText()