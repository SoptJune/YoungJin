import java.lang.Math.min
import kotlin.math.max

// https://www.acmicpc.net/problem/2468

lateinit var visit: Array<BooleanArray>
lateinit var heightList: Array<IntArray>
val br = System.`in`.bufferedReader()
val n = br.readLine().toInt()
var minHeight = 100
var maxHeight = 1

fun main() {
    initVisit()
    heightList = Array(n) { IntArray(n) }

    repeat(n) { idx ->
        heightList[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    findMinMaxHeight()
    searchSafeZone()
}

fun initVisit() {
    visit = Array(n) { BooleanArray(n) { false } }
}

/** 입력된 높이리스트에서 최소, 최대를 찾아 안전영역을 탐색 시 기준이 되는 높이 범위를 구한다. */
fun findMinMaxHeight() {
    for (row in 0 until n) {
        for (col in 0 until n) {
            minHeight = min(minHeight, heightList[row][col])
            maxHeight = max(maxHeight, heightList[row][col])
        }
    }
}

/** 내리는 비의 높이마다 안전영역 탐색 */
fun searchSafeZone() {
    var maxCount = 1
    for (height in minHeight until maxHeight) {
        var count = 0
        initVisit()

        for (row in 0 until n) {
            for (col in 0 until n) {
                if (!visit[row][col] && heightList[row][col] > height) {
                    visit[row][col] = true
                    count++
                    dfs(height, row, col)
                }
            }
        }
        maxCount = max(maxCount, count)
    }
    println(maxCount)
}

val dy = intArrayOf(1, -1, 0, 0)
val dx = intArrayOf(0, 0, 1, -1)
fun dfs(rainfall: Int, y: Int, x: Int) {
    for (i in 0 until 4) {
        val _y = y + dy[i]
        val _x = x + dx[i]

        if (_y < 0 || _y >= n || _x < 0 || _x >= n) continue
        if (visit[_y][_x] || heightList[_y][_x] <= rainfall) continue

        visit[_y][_x] = true
        dfs(rainfall, _y, _x)
    }
}