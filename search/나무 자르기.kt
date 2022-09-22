// https://www.acmicpc.net/problem/2805

lateinit var trees: List<Long>
fun main() {
    val br = System.`in`.bufferedReader()
    val (_, m) = br.readLine().split(" ").map { it.toInt() }
    trees = br.readLine().split(" ").map { it.toLong() }

    println(getMaxHeightOfCutter(m, trees.maxOrNull() ?: return))
}

fun getMaxHeightOfCutter(m: Int, maxTreeLength: Long): Long {
    var total: Long
    var mid: Long
    var min = 1L
    var max = maxTreeLength
    var ans = 0L

    while (min <= max) {
        mid = (min + max) / 2
        total = trees.sumOf { tree ->
            (tree - mid).let { rest ->
                if (rest > 0) rest else 0
            }
        }

        if (total >= m) {
            min = mid + 1
            ans = mid
        } else {
            max = mid - 1
        }
    }
    return ans
}