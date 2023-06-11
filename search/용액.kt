// https://www.acmicpc.net/problem/2467

import kotlin.math.abs

lateinit var liquids: List<Int>

fun main() {
    readln().toInt()
    liquids = readln().split(" ").map { it.toInt() }.sorted()
    binarySearch()
}

fun binarySearch() {
    var start = 0
    var end = liquids.size - 1
    var diff = 2_000_000_000
    var ans = Pair(liquids[start], liquids[end])

    while (start < end) {
        val tmpSum = liquids[start] + liquids[end]
        val tmpDiff = abs(tmpSum)
        if (tmpDiff < diff) {
            diff = tmpDiff
            ans = Pair(liquids[start], liquids[end])
        }

        if (tmpSum < 0) start++
        else end--
    }

    println("${ans.first} ${ans.second}")
}
