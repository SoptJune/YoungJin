//https://www.acmicpc.net/problem/11404

val br = System.`in`.bufferedReader()
lateinit var dp: Array<LongArray>
const val INF = Integer.MAX_VALUE.toLong()

fun main() {
    (br.readLine().toInt()).let { size ->
        initDp(size)
        calculateMinCost(size)
        printDp(size)
    }
}

fun initDp(size: Int) {
    dp = Array(size + 1) { i ->
        LongArray(size + 1) { j ->
            if (i == j) 0
            else INF
        }
    }

    repeat(br.readLine().toInt()) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        dp[a][b] = dp[a][b].coerceAtMost(c.toLong()) // 같은 간선이 여러 번 주어질 수 있음. 이 경우를 위해 가장 비용이 적은 간선을 저장.
    }
}

fun calculateMinCost(size: Int) {
    for (k in 1 .. size)
        for (i in 1 .. size)
            for (j in 1 .. size)
                dp[i][j] = dp[i][j].coerceAtMost(dp[i][k] + dp[k][j]) // i -> j로 바로가는 것과 k를 경유해서 갈 때의 비용을 비교. 최소 비용으로 갱신
}

fun printDp(size: Int) {
    for (i in 1 .. size) {
        for (j in 1 .. size)
            print("${dp[i][j].convertINFToZero()} ") // 연결이 안되어있는 경우(MAX_VALUE) 0으로 출력
        println()
    }
}

fun Long.convertINFToZero() = if (this == INF) 0 else this