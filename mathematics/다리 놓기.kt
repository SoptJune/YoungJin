// https://www.acmicpc.net/problem/1010

val dp = Array(31) { IntArray(31) }
fun main() {
    val br = System.`in`.bufferedReader()

    for (i in 1 until dp.size) {
        for (j in 0..i) {
            when (j) {
                0 -> dp[i][j] = 1
                1 -> dp[i][j] = i
                else -> dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            }
        }
    }

    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        println(dp[m][n])
    }
}