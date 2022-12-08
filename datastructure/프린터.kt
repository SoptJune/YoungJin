import java.util.LinkedList

// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=kotlin

fun main() {
    println(solution2(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}

fun solution1(priorities: IntArray, location: Int): Int {
    var answer = 1
    val docs = LinkedList<Pair<Int, Int>>() // 문서의 인덱스, 우선순위를 포함

    for (i in priorities.indices)
        docs.add(Pair(i, priorities[i]))

    var max = docs.maxOfOrNull { it.second }
    while (docs.isNotEmpty()) {
        val current = docs.pop() // 1. 첫번째 요소를 꺼냄

        if (current.second == max) { // 2. 꺼낸 요소의 우선 순위가 최댓값이면 인쇄한다.
            if (current.first == location) return answer // 3. 이때 요청한 문서에 해당하면 answer(몇번째에 인쇄되었는지)을 반환한다.
            else answer++ // 4. 요청한 문서가 아니라면 인쇄 수를 증가만 시킨다.
            max = docs.maxOfOrNull { it.second } // 5. 꺼낸 요소가 최댓값이므로 남은 요소 중에서 최댓값을 찾아 max를 갱신한다.
        } else {
            docs.add(current) // 6. 우선순위가 최대가 아니므로 다시 인쇄큐의 맨뒤로 들어간다.
        }
    }

    return answer
}

fun solution2(priorities: IntArray, location: Int): Int {
    var answer = 1
    val docs = LinkedList<Document>()

    for (i in priorities.indices)
        docs.add(Document(i, priorities[i]))

    var max = docs.maxOfOrNull { it.priority }
    while (docs.isNotEmpty()) {
        val current = docs.pop()

        if (current.priority == max) {
            if (current.idx == location) return answer
            else answer++
            max = docs.maxOfOrNull { it.priority }
        } else {
            docs.add(current)
        }
    }

    return answer
}

data class Document(
    val idx: Int,
    val priority: Int,
)