// https://www.acmicpc.net/problem/10422

const val MOD = 1_000_000_007L
val dp = Array(5001) { 0L }

fun main() {
    val br = System.`in`.bufferedReader()
    initDp()
    Array(br.readLine().toInt()) { br.readLine().toInt() }.forEach { length ->
        println(dp[length])
    }
}

fun initDp() {
    dp[0] = 1L // 괄호 0개 : 아무것도 넣지 않는 경우 한가지를 의미
    for (i in 2..5000 step (2))
        for (j in 2..i step (2))
            dp[i] = (dp[i] + (dp[j - 2] * dp[i - j])) % MOD
}
