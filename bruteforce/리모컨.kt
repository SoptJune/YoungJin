import java.lang.Math.min
import kotlin.math.abs

// https://www.acmicpc.net/problem/1107

val broken = BooleanArray(10) // 고장난 버튼 배열로, 고장난 버튼은 true, 고장나지 않은 버튼은 false가 저장되어있음
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    if (m > 0) {
        br.readLine().split(" ").forEach { brokenStr ->
            broken[brokenStr.toInt()] = true
        }
    }

    if (n == 100) {
        println(0); return
    }

    var ans = abs(n - 100) // 현재 채널은 1️⃣0️⃣0️⃣번 임
    for (i in 0..1000000) {
        val numOfInput = getNumOfInput(i)
        if (numOfInput > 0) {
            val numOfUpDown = abs(n - i)
            ans = min(ans, numOfInput + numOfUpDown)
        }
    }

    println(ans)
}

/** 숫자버튼 입력 횟수 구하기 (단, 0을 반환할 경우 해당 숫자는 입력 불가) */
fun getNumOfInput(n: Int): Int {
    if (n == 0) return if (broken[n]) 0 else 1

    var num = n
    var count = 0
    while (num > 0) {
        if (broken[num % 10]) return 0
        num /= 10
        count++
    }

    return count
}