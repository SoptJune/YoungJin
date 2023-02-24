// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=kotlin

fun main() {
    println(solution(intArrayOf(1, 1, 1, 1, 1), 3))
}

fun solution(numbers: IntArray, target: Int): Int {
    var values = mutableListOf(0)
    var tmp: MutableList<Int>

    numbers.forEach { num ->
        tmp = mutableListOf()
        values.forEach { value ->
            tmp.add(value - num)
            tmp.add(value + num)
        }
        values = tmp
    }

    return values.count { it == target }
}