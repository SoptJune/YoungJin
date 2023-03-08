// https://www.acmicpc.net/problem/2638

import java.util.*

val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)
var n = 0;
var m = 0
lateinit var cheeze: Array<MutableList<Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine().split(" ").map { it.toInt() }.also {
        n = it[0]
        m = it[1]
    }
    cheeze = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    var time = 0
    while (true) {
        var total = 0
        for (i in 0 until n) total += cheeze[i].sum()
        if (total == 0) {
            print(time)
            break
        }
        bfs()
        time++
    }
}

fun bfs() {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    val visited = Array(n) { Array(m) { false } }
    visited[0][0] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.pop()
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny]) {
                if (cheeze[nx][ny] == 0) {
                    queue.add(Pair(nx, ny))
                    visited[nx][ny] = true
                } else {
                    cheeze[nx][ny]++
                }
            }
        }
    }
    melt()
}

fun melt() {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (cheeze[i][j] >= 3) cheeze[i][j] = 0
            else if (cheeze[i][j] == 2) cheeze[i][j] = 1
        }
    }
}
