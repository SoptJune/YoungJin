//https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=kotlin

fun main() {
    println(solution(arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))))
}

fun solution(sizes: Array<IntArray>): Int {
    var edge1 = 0 // 가로 세로 중 짧은 길이 중 최대 길이
    var edge2 = 0 // 가로 세로 중 긴 길이 중 최대 길이
    sizes.forEach { size ->
        getMinMax(size).also {
            edge1 = edge1.coerceAtLeast(it.first)
            edge2 = edge2.coerceAtLeast(it.second)
        }
    }

    return edge1 * edge2
}

/** 전달 받은 가로, 세로 길이 값 중 짧은 것(min)을 first로, 긴 것(max)을 second로 반환 */
fun getMinMax(size: IntArray): Pair<Int, Int> =
    if (size[0] < size[1]) Pair(size[0], size[1])
    else Pair(size[1], size[0])
