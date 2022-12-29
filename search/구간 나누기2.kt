// https://www.acmicpc.net/problem/13397

lateinit var arr: List<Int>
var m = 0

fun main() {
    val br = System.`in`.bufferedReader()
    m = br.readLine().split(" ").map { it.toInt() }[1]
    arr = br.readLine().split(" ").map { it.toInt() }

    var s = 0
    var e = arr.maxOrNull()!!
    var mid: Int
    var ans = e // 문제에서 구하고자는 최댓값 중 최솟값
    while (s <= e) {
        mid = (s + e) / 2
        if (isValid(mid)) { // 계산한 구간의 수가 주어진 구간 수 m이하라면
            ans = mid.coerceAtMost(ans) // mid값 중 가장 작은 값이라면 ans 갱신
            e = mid - 1 // mid값 줄이기
        } else { // 계산한 구간의 수가 주어진 구간 수 m을 초과했다면
            s = mid + 1 // mid값 늘리기
        }
    }

    println(ans)
}

fun isValid(mid: Int): Boolean {
    var sectionCount = 1
    var maxNum = arr[0]
    var minNum = arr[0]

    for (i in 1 until arr.size) {
        if (arr[i] > maxNum) maxNum = arr[i]
        if (arr[i] < minNum) minNum = arr[i]
        if (maxNum - minNum > mid) { // 최대, 최소 값 차이가 mid 보다 크면 이전 인덱스까지를 한 구간으로 간주.
            sectionCount++
            maxNum = arr[i]
            minNum = arr[i]
        }
    }

    return m >= sectionCount
}