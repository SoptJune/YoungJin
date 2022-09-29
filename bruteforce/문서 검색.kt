// https://www.acmicpc.net/problem/1543

fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val target = br.readLine()
    var idx = 0
    var count = 0

    while (idx <= str.length - target.length) {
        if (str.substring(idx, idx + target.length) == target) {
            count++
            idx += target.length
        } else {
            idx += 1
        }
    }

    println(count)
}