// https://www.acmicpc.net/problem/1484

fun main() {
    val br = System.`in`.bufferedReader()
    val G = br.readLine().toInt()
    val ans = mutableListOf<Int>()
    var currentW = 2
    var memoryW = 1

    while (memoryW < currentW) {
        val diff = currentW * currentW - memoryW * memoryW
        if (diff == G) {
            ans.add(currentW)
            currentW++
            memoryW++
        } else if (diff < G) {
            currentW++
        } else {
            memoryW++
        }
    }

    if (ans.isEmpty()) println(-1)
    else ans.forEach { println(it) }
}