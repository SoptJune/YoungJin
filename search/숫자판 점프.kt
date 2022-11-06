// https://www.acmicpc.net/problem/2210

const val SIZE = 5
val dx = listOf(0, 0, -1, 1)
val dy = listOf(-1, 1, 0, 0)
val numPad = Array(SIZE) { listOf<String>() }
val strSet = mutableSetOf<String>()

fun main() {
    repeat(SIZE) { idx ->
        numPad[idx] = readln().split(" ")
    }

    for (y in 0 until SIZE)
        for (x in 0 until SIZE)
            dfs(1, numPad[y][x], x, y)

    println(strSet.size)
}

fun dfs(len: Int, numStr: String, x: Int, y: Int) {
    if (len == 6) {
        strSet.add(numStr)
        return
    }

    for (i in 0 until 4) {
        val _x = x + dx[i]
        val _y = y + dy[i]
        if (_y < 0 || _y >= SIZE || _x < 0 || _x >= SIZE) continue
        dfs(len + 1, numStr + numPad[_y][_x], _x, _y)
    }
}
