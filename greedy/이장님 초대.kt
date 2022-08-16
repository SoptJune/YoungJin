import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

// https://www.acmicpc.net/problem/9237

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numOfGraves = br.readLine().toInt() // 사용되지 않는 변수 ^^
    val days = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    var total = 0
    var cur = 0

    for ((idx, d) in days.withIndex()) {
        cur = idx + 1 + d
        if (total < cur) total = cur
    }

    print(total + 1) // 마지막 나무가 다 자란 '다음날' 이장님 초대
}