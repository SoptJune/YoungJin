// https://www.acmicpc.net/problem/7579

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val byteList = br.readLine().split(" ").map { it.toInt() }
    val costList = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(costList.sum() + 1) { 0 } // 해당 비활성화 비용으로 확보할 수 있는 메모리의 양 => "dp[비용] = 구할 수 있는 최대 byte"임. 동일 비용으로 구할 수 있는 메모리가 여러 case로 존재할 수 있음. 따라서 비용이 동일할 때 최대 메모리 양을 가지는 것이 최소 비용을 찾는 데 더욱 유리하기에 해당 비용을 들여 확보할 수 있는 최대 메모리양을 저장.

    for (i in 0 until N)
        for (j in costList.sum() downTo 0)
            if (j >= costList[i]) // 현재 앱을 비활성화할만큼 cost가 충분하면
                dp[j] = max(dp[j], dp[j - costList[i]] + byteList[i]) // 동일 비용 j를 소모한다하면, 현재 앱의 비활성화 하지 않았을 때와 비활성화 했을 때의 byte를 구해 최댓값으로 dp[j]를 업데이트

    // 필요한 메모리양 M 이상인 비용을 출력
    dp.forEachIndexed { cost, byte ->
        if (byte >= M) {
            print(cost)
            return
        }
    }
}
