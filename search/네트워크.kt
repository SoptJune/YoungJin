// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=kotlin

fun main() {
    println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))))
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    var count = 0
    val visited = Array(n) { false }

    for (start in 0 until n) {
        if (!visited[start]) {
            dfs(start, visited, computers)
            count++
        }
    }

    return count
}

fun dfs(start: Int, visited: Array<Boolean>, computers: Array<IntArray>) {
    visited[start] = true

    for (end in 0 until computers[start].size) {
        if (end != start && computers[start][end] == 1 && !visited[end])
            dfs(end, visited, computers)
    }
}