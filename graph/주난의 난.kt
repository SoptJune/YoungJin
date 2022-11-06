// https://www.acmicpc.net/problem/14497

val br = System.`in`.bufferedReader()
var n = 0; var m = 0;
var x1 = 0; var y1 = 0; var x2 = 0; var y2 = 0;
var isFound = false
val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)
var arr: MutableList<CharArray> = mutableListOf()
lateinit var visited: Array<IntArray>

fun main() {
    br.readLine().split(" ").let {
        n = it[0].toInt()
        m = it[1].toInt()
    }

    br.readLine().split(" ").let {
        x1 = it[0].toInt() - 1
        y1 = it[1].toInt() - 1
        x2 = it[1].toInt() - 1
        y2 = it[1].toInt() - 1
    }

    repeat(n) {
       arr.add(br.readLine().toCharArray())
    }
    visited = Array(n) { IntArray(m) }

    arr[x1][y1] = '0'

    var i = 0
    while (!isFound) dfs(x1, y1, ++i)
}

fun dfs(x: Int, y: Int, count: Int) {
    visited[x][y] = count

    if (arr[x][y] == '#') {
        isFound = true
        println(count)
        return
    }

    if (arr[x][y] == '1') {
        arr[x][y] = '0'
        return
    }

    for (i in 0 until 4) {
        val _x = x + dx[i]
        val _y = y + dy[i]
        if (_y < 0 || _y >= m || _x < 0 || _x >= n) continue
        if (visited[_x][_y] == count) continue
        dfs(_x, _y, count)
    }
}