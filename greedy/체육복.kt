// https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=kotlin

fun main() {
    println(solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(solution(5, intArrayOf(2, 4), intArrayOf(3)))
    println(solution(3, intArrayOf(3), intArrayOf(1)))
    println(solution(10, intArrayOf(5, 7, 9), intArrayOf(1, 2, 3, 4, 6, 8)))
    println(solution(2, intArrayOf(2), intArrayOf(2)))
}

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val reserveSet = reserve.sorted().toMutableSet()
    val lostSet = lost.sorted().toMutableSet()
    val intersection = lostSet.intersect(reserveSet)
    lostSet.apply { removeAll(intersection) }
    reserveSet.apply { removeAll(intersection) }

    reserveSet.forEach { num ->
        if (lostSet.contains(num - 1)) lostSet.remove(num - 1)
        else if (lostSet.contains(num + 1)) lostSet.remove(num + 1)
    }
    return n - lostSet.size
}