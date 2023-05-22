// https://www.acmicpc.net/problem/15685

// 0, 1, 2, 3 방향
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, -1, 0, 1)
val visited = Array(101) { IntArray(101) }

fun main() {
    repeat(readln().toInt()) {
        var (x, y, d, g) = readln().split(" ").map { it.toInt() }
        val dList = mutableListOf(d)
        visited[x][y] = 1

        // 세대만큼 반복
        repeat(g) {
            val tmp = mutableListOf<Int>() // 이전 세대 커브의 역방향으로 각 요소 d에 (d + 1) % 4를 적용 (4 : 방향은 0 ~ 3으로 나타냄)
            for (i in dList.size - 1 downTo 0)
                tmp.add((dList[i] + 1) % 4)

            // 이전 세대 커브에 tmp를 더함
            dList.addAll(tmp)
        }

        // dList의 방향값을 통해 좌표 계산 및 방문 처리
        for (d in dList) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            visited[nx][ny] = 1
            x = nx; y = ny // 방향을 고려해서 현재 좌표 갱신 처리
        }
    }

    // 사각형 갯수 계산
    var ans = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (visited[i][j] == 1 && visited[i + 1][j] == 1 && visited[i][j + 1] == 1 && visited[i + 1][j + 1] == 1) ans += 1
        }
    }
    print(ans)
}
