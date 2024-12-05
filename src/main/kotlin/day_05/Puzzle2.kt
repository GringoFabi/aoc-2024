package gringo.fabi.aoc.day_05


fun Pair<List<String>, List<String>>.repairOrdersAndCalculateMiddleSum(): Int {
    val rules = first.readRules()
    val printOrders = second.toIntArrayList()

    val invalidOrders = printOrders.filterNot { it.validate(rules) }

    // repair the invalid orders and return the sum of the middle elements
    return invalidOrders
        .map { it.repair(rules) }
        .sumOf { it[it.size / 2] }
}

fun List<Int>.repair(rules: Set<Pair<Int, Int>>): List<Int> =
    sortedWith { a, b -> if (rules.contains(Pair(a, b))) -1 else 1 }
