// https://www.acmicpc.net/problem/9177

import java.util.*

lateinit var visited: Array<IntArray>

fun main() {
    repeat(readln().toInt()) { idx ->
        readln().split(" ").let {
            val yesOrNo = if (isValidDataset(it[0], it[1], it[2])) "yes" else "no"
            println("Data set ${idx + 1}: $yesOrNo")
        }
    }
}

fun isValidDataset(w1: String, w2: String, w3: String): Boolean {
    visited = Array(w1.length + 1) { IntArray(w2.length + 1) }
    val queue = LinkedList(listOf(Triple(0, 0, 0)))

    while (queue.isNotEmpty()) {
        val (w1Idx, w2Idx, w3Idx) = queue.pop()
        if (w3Idx == w3.length) {
            return true
        }
        if (w1Idx < w1.length && visited[w1Idx + 1][w2Idx] == 0 && w1[w1Idx] == w3[w3Idx]) {
            visited[w1Idx + 1][w2Idx] = 1
            queue.add(Triple(w1Idx + 1, w2Idx, w3Idx + 1))
        }
        if (w2Idx < w2.length && visited[w1Idx][w2Idx + 1] == 0 && w2[w2Idx] == w3[w3Idx]) {
            visited[w1Idx][w2Idx + 1] = 1
            queue.add(Triple(w1Idx, w2Idx + 1, w3Idx + 1))
        }
    }

    return false
}