package day_05

import gringo.fabi.aoc.day_05.readRules
import gringo.fabi.aoc.day_05.toIntArrayList

fun Pair<List<String>, List<String>>.validateOrdersAndCalculateMiddleSum(): Int {
    val rules = first.readRules()
    val printOrders = second.toIntArrayList()

    val validOrders = printOrders.applyRules(rules)

    // return the sum of the middle elements of the valid orders
    return validOrders.sumOf { it[it.size / 2] }
}

fun List<List<Int>>.applyRules(rules: Set<Pair<Int, Int>>) = filter { it.toList().validate(rules) }

fun List<Int>.validate(rules: Set<Pair<Int, Int>>): Boolean = zipWithNext().all { rules.contains(it) }
