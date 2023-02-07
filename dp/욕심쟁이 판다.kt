// https://www.acmicpc.net/problem/1937

lateinit var bamboo: Array<List<Int>>
lateinit var dp: Array<Array<Int>>
var N: Int = 0

fun main() {
    val br = System.`in`.bufferedReader()
    N = br.readLine().toInt()
    bamboo = Array(N) { br.readLine().split(" ").map { it.toInt() } }
    dp = Array(N) { Array(N) { -1 } }

    var ans = 0
    for (i in 0 until N)
        for (j in 0 until N)
            ans = ans.coerceAtLeast(dfs(i, j))

    print(ans)
}

val dx = listOf(0, 0, -1, 1)
val dy = listOf(1, -1, 0, 0)
fun dfs(x: Int, y: Int): Int {
    if (dp[x][y] == -1) {
        dp[x][y] = 1
        var nx: Int; var ny: Int; var tmp = 0
        for (idx in dx.indices) {
            nx = x + dx[idx]
            ny = y + dy[idx]

            if (nx in 0 until N && ny in 0 until N && bamboo[x][y] < bamboo[nx][ny])
                tmp = tmp.coerceAtLeast(dfs(nx, ny))
        }
        dp[x][y] += tmp
    }

    return dp[x][y]
}
