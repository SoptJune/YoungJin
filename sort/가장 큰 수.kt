// https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=kotlin

fun main() {
    println(solution(intArrayOf(6, 10, 2)))
}

fun solution(numbers: IntArray): String {
    val answer = numbers.map { it.toString() }.sortedWith { a, b -> (b + a).compareTo(a + b) }.joinToString("")
    return if (answer[0] == '0') return "0" else answer
}