// https://school.programmers.co.kr/learn/courses/30/lessons/84021

fun main() {
    // 작성 중..
}

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun dfs(x: Int, y: Int, pos: Pair<Int, Int>, target: Int, matrix: Array<IntArray>): List<Pair<Int, Int>> {
    if (matrix[x][y] == 2) return mutableListOf()
    matrix[x][y] = 2

    val res = mutableListOf(pos)

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx >= 0 && nx < matrix.size && ny >= 0 && ny < matrix.size && matrix[nx][ny] == target)
            res.addAll(dfs(nx, ny, Pair(pos.first + dx[i], pos.second + dy[i]), target, matrix))
    }

    return res
}

fun rotate(row: Int, col: Int, matrix: Array<IntArray>): Array<IntArray> {
    val result = Array(col) { IntArray(row) }
    for (i in 0..row)
        for (j in 0..col)
            result[col][row - 1 - i] = matrix[i][j]
    return result
}
