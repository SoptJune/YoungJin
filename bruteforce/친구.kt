// https://www.acmicpc.net/problem/1058

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val friendList = mutableListOf<CharArray>()
    val n = br.readLine().toInt()
    var res = 0

    repeat(n) {
        friendList.add(br.readLine().toCharArray())
    }

    for (i in 0 until n) {
        val visit = BooleanArray(n)
        for (j in 0 until n) {
            if (friendList[i][j] == 'Y') {
                visit[j] = true
                for (k in 0 until n) {
                    if (friendList[j][k] == 'Y') visit[k] = true
                }
            }
        }
        visit[i] = false // 본인 제외
        res = max(res, visit.count { it }) // i의 친구 수를 계산한 후, 친구 수 최댓값(res)과 비교하여 res 갱신
    }

    println(res)
}