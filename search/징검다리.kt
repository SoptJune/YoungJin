// https://school.programmers.co.kr/learn/courses/30/lessons/43236?language=kotlin

lateinit var points: MutableList<Int>

fun main() {
    println(solution(25, intArrayOf(2, 14, 11, 21, 17), 2))
}

fun solution(distance: Int, rocks: IntArray, n: Int): Int {
    rocks.sort()
    points = rocks.toMutableList().apply { add(distance) }

    var answer = distance
    var start = 0
    var end = distance
    var mid = 0

    while (start <= end) {
        mid = (start + end) / 2
        val result = removeRock(mid)
        if (result.first > n) {
            end = mid - 1
        }
        else {
            start = mid + 1
            answer = result.second
        }
    }

    return answer
}

fun removeRock(targetDiff: Int): Pair<Int, Int> {
    var currentPoint = 0
    var removedCount = 0
    var min = points.last()
    var diff = 0

    for (i in points.indices) {
        diff = points[i] - currentPoint
        if (diff < targetDiff) {
            removedCount++
        }
        else {
            currentPoint = points[i]
            min = min.coerceAtMost(diff)
        }
    }
    
    return Pair(removedCount, min)
}