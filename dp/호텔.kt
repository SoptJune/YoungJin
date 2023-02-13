// https://www.acmicpc.net/problem/1106

const val MAX_COST = 100 * 1000 // Worst Case :  각 도시당 홍보 비용 100원(1명 당) * 1000명(C의 최댓값) => 100,000원
val dp = Array(MAX_COST) { 0 }
lateinit var cityInfo: Array<Pair<Int, Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val (c, n) = br.readLine().split(" ").map { it.toInt() }

    cityInfo = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.let { Pair(it[0], it[1]) }
    }

    print(dp(c)) // 목표 고객 수
}

fun dp(numOfGuest: Int): Int { // 남은 고객 수
    if (numOfGuest <= 0) return 0 // 목표로 설정한 고객 수를 달성했다면 더이상 탐색 X
    if (dp[numOfGuest] > 0) return dp[numOfGuest] // 해당 고객 수에 대한 홍보 비용이 구해져있다면 이 값을 사용

    var curCost = 0
    var minCost = MAX_COST
    for ((cost, guest) in cityInfo) {
        curCost = dp(numOfGuest - guest) + cost // 해당 도시에서 홍보했을 때의 비용을 계산
        minCost = if(curCost < minCost) curCost else minCost // 해당 비용이 지금까지 구한 최소 비용보다 작다면 최소 비용을 갱신
    }
    dp[numOfGuest] = minCost // 해당 고객 수에 대한 최소 비용 할당
    return minCost
}