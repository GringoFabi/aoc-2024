package gringo.fabi.aoc.day_04

import java.io.InputStream

const val RESOURCE = "puzzles/04_1_input.txt"

fun InputStream.readToCharacterMatrix(): Array<CharArray> = bufferedReader().readLines().map { it.toCharArray() }.toTypedArray()