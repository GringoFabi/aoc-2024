package gringo.fabi.aoc.day_02

fun List<Report>.numberOfSafeReports(): Int = count { it.isSafe() }

fun Report.isSafe(): Boolean = when {
    isAscending() -> zipWithNext().all { (a, b) -> (b - a) in 1..3 }
    isDescending() -> zipWithNext().all { (a, b) -> (a - b) in 1..3 }
    else -> false
}
