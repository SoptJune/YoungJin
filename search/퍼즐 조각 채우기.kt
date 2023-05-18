// https://school.programmers.co.kr/learn/courses/30/lessons/84021

fun main() {
    println(
        solution(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 0, 1),
                intArrayOf(1, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 1, 1, 0, 0)
            ),
            arrayOf(
                intArrayOf(1, 0, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(1, 1, 0, 1, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 0),
            )
        )
    )
}

const val GAME_TARGET = 0
const val TABLE_TARGET = 1

fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
    var answer: Int = -1

    // 1. 게임보드에서는 블록이 들어갈 수 있는 빈 블럭 리스트를, 테이블에서는 게임보드에 올릴 블럭 리스트를 추출한다. (단, 각 블럭의 시작 블럭 좌표는 0, 0으로 두어 하나의 블록 모음 내에서 각 블럭 들의 좌표를 리스트로 반환.)
    val gameBlocks = mutableListOf<Array<IntArray>>()
    val tableBlocks = mutableListOf<Array<IntArray>>()
    for (i in table.indices) {
        for (j in table.indices) {
            if (game_board[i][j] == GAME_TARGET)
                gameBlocks.add(makeBoard(dfs(i, j, Pair(0, 0), GAME_TARGET, game_board)))

            if (table[i][j] == TABLE_TARGET)
                tableBlocks.add(makeBoard(dfs(i, j, Pair(0, 0), TABLE_TARGET, table)))
        }
    }

    val isUsed = BooleanArray(tableBlocks.size) // 테이블 블록 중 사용된 블록을 표시
    gameBlocks.forEach { gb ->
        tableBlocks.forEachIndexed { index, tb ->
            if (gb.size * gb[0].size == tb.size * tb[0].size) {
                var rt = tb
                for (i in 0 until 4) {
                    if (!isUsed[index] && gb.contentEquals(rt)) {
                        isUsed[index] = true
                        answer += rt.size
                        break
                    } else {
                        rt = rotate(rt)
                    }
                }
            }
        }
    }

    return answer
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
            res.addAll(dfs(nx, ny, Pair(pos.first + dx[i], pos.second + dy[i]), target, matrix)) // 0, 0 기준으로 블록 추출
    }

    return res
}

fun makeBoard(points: List<Pair<Int, Int>>): Array<IntArray> { // 좌표 리스트를 직사각형 형태로 변환. 존재하는 좌표는 1로, 그렇지 않은 경우는 0으로 지정해서 사각형 반환
    val maxX = points.maxOfOrNull { it.first }!!
    val maxY = points.maxOfOrNull { it.second }!!

    println(points)
    val board = Array(maxX + 1) { IntArray(maxY + 1) }
    points.forEach { point ->
        board[point.first][point.second] = 1
    }
    return board
}

fun rotate(matrix: Array<IntArray>): Array<IntArray> {
    val row = matrix.size
    val col = matrix[0].size
    val result = Array(col) { IntArray(row) }

    for (i in 0..row)
        for (j in 0..col)
            result[col][row - 1 - i] = matrix[i][j]
    return result
}
