// https://www.acmicpc.net/problem/1654

val cables = mutableListOf<Long>()
fun main() {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().split(" ").map { it.toInt() }

    repeat(k) {
        cables.add(br.readLine().toLong())
    }

    println(getMaxLengthOfCable(n, cables.maxOrNull() ?: return))
}

fun getMaxLengthOfCable(n: Int, maxCableLength: Long): Long {
    var count: Long
    var mid: Long
    var min = 1L
    var max = maxCableLength
    var ans = 0L

    while (min <= max) {
        mid = (min + max) / 2
        count = cables.sumOf { it / mid }

        if (count >= n) {
            min = mid + 1
            ans = mid
        } else {
            max = mid - 1
        }
    }
    return ans
}