//https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=kotlin

fun main() {
    println(solution("AAAAE"))
}

fun solution(word: String): Int {
    var answer = 0
    val index = mapOf('A' to 0, 'E' to 1, 'I' to 2, 'O' to 3, 'U' to 4)
    val numOfCasesByDigit = arrayOf(781, 156, 31, 6, 1)

    for (i in word.indices)
        answer += index[word[i]]!! * numOfCasesByDigit[i] + 1

    return answer
}