import kotlin.math.max

// https://www.acmicpc.net/problem/2579

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stair = ArrayList<Int>()
    val dp = IntArray(n)

    repeat(n) {
        stair.add(br.readLine().toInt())
    }

    if (n == 1) {
        println(stair[0]); return
    } else if (n == 2) {
        println(stair[0] + stair[1]); return
    }

    dp[0] = stair[0]
    dp[1] = stair[0] + stair[1]
    dp[2] = max(stair[0] + stair[2], stair[1] + stair[2])

    for (i in 3 until n)
        dp[i] = max(stair[i] + stair[i - 1] + dp[i - 3], stair[i] + dp[i - 2])

    println(dp[n - 1])
}
