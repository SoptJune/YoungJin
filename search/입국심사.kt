// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=kotlin

fun main() {
    println(solution(6, intArrayOf(7, 10)))
}

fun solution(n: Int, times: IntArray): Long {
    var answer: Long = 0
    var start = 0L
    var end = times.maxOrNull()?.toLong()?.times(n)!!
    var mid: Long
    var numOfPeople: Long

    while (start <= end) {
        mid = (start + end) / 2
        numOfPeople = 0L

        times.forEach { time ->
            numOfPeople += mid / time
            if (numOfPeople >= n) return@forEach
        }

        if (numOfPeople >= n) {
            end = mid - 1L
            answer = mid

        } else {
            start = mid + 1L
        }
    }

    return answer
}