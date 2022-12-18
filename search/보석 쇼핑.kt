// https://school.programmers.co.kr/learn/courses/30/lessons/67258?language=kotlin

fun main() {
    println(
        solution(arrayOf("DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"))
    )
    println(
        solution(arrayOf("A"))
    )
    println(
        solution(arrayOf("A", "B", "C", "C", "D", "A", "B", "C", "D"))
    )
}

fun solution(gems: Array<String>): IntArray {
    val section = intArrayOf(1, gems.size)
    val numOfJewels = gems.toSet().size
    val dic = hashMapOf<String, Int>()
    var start = 0
    var end = 0

    while (end < gems.size) {
        dic[gems[end]] = dic[gems[end]]?.plus(1) ?: 1
        end++

        if (numOfJewels == dic.size) {
            while (start < end) {
                if (dic[gems[start]]!! > 1) {
                    dic[gems[start]] = dic[gems[start]]!! - 1
                    start++
                } else if (section[1] - section[0] > end - 1 - start) {
                    section[0] = start + 1; section[1] = end
                    break
                } else {
                    break
                }
            }
        }
    }

    println("${section[0]}, ${section[1]}")
    return section
}