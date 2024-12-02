package gringo.fabi.aoc.day_02

fun List<Report>.numberOfTolerantSafeReports(): Int = count { it.isSafeWithTolerance() }

fun Report.isSafeWithTolerance(): Boolean {
    if (isSafe()) return true

    // check if removing any element would make the report safe
    return indices.any { toMutableList().apply { removeAt(it) }.isSafe() }
}