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
    val section = intArrayOf(1, gems.size) // 모든 보석이 존재하는 최단 구간
    val numOfJewels = gems.toSet().size
    val dic = hashMapOf<String, Int>()
    var start = 0
    var end = 0

    while (end < gems.size) { // end 인덱스가 gems 사이즈 보다 작을 동안 반복
        dic[gems[end]] = dic[gems[end]]?.plus(1) ?: 1 // 현재 end 위치에 있는 보석이 딕셔너리에 있으면 +1 없으면 1로 세팅
        end++

        if (numOfJewels == dic.size) { // 딕셔너리가 모든 종류의 보석을 다 포함하고 있다면
            while (start < end) { // start 인덱스가 end 인덱스보다 작을 동안 반복
                if (dic[gems[start]]!! > 1) { // 딕셔너리에서 start 위치에 있는 보석이 한 개 이상이라면
                    dic[gems[start]] = dic[gems[start]]!! - 1 // 보석을 하나 제거
                    start++
                } else if (section[1] - section[0] > end - 1 - start) { // 기존 구간보다 현재 구간이 더 짧다면
                    section[0] = start + 1; section[1] = end // 현재 구간으로 갱신
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