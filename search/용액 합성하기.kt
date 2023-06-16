// https://www.acmicpc.net/problem/14921

import kotlin.math.abs

lateinit var liquids: List<Int>

fun main() {
    readln().toInt()
    liquids = readln().split(" ").map { it.toInt() }.sorted()
    print(binarySearch())
}

fun binarySearch(): Int {
    var start = 0
    var end = liquids.size - 1
    var sum = 2_000_000_000
    var diff = sum
    var ans = sum

    while (start < end) {
        sum = liquids[start] + liquids[end]
        if (abs(sum) < diff) {
            diff = abs(sum)
            ans = sum
        }

        if (sum < 0) start++
        else end--
    }

    return ans
}
