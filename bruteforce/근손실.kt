// https://www.acmicpc.net/problem/18429
// https://notepad96.tistory.com/108 (순열 참고)

const val WEIGHT = 500
lateinit var kits: List<Int>
var K = 0

fun main() {
    val br = System.`in`.bufferedReader()
    K = br.readLine().split(" ").map { it.toInt() }[1]
    kits = br.readLine().split(" ").map { it.toInt() }

    var ans = 0
    val test = kits.indices.toList().permutationAll()

    for (order in test)
        if (isValidOrder(order))
            ans++

    print(ans)
}

fun isValidOrder(order: List<Int>): Boolean  {
    var sum = WEIGHT
    for (idx in order) {
        sum += (kits[idx] - K)
        if(sum < WEIGHT) return false
    }
    return true
}

fun permutation(sub: List<Int>, fin: List<Int> = listOf()): List<List<Int>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(sub - it, fin + it) }
}

private fun List<Int>.permutationAll(
    r: Int = this.size,
    curArr: MutableList<Int> = MutableList(r) { 0 },
    visited: Int = 0,
    result: MutableList<List<Int>> = mutableListOf()
): List<List<Int>> {
    if (r == 0) {
        result.add(curArr.toList())
        return emptyList()
    }
    forEachIndexed { i, v ->
        if (visited and (1 shl i) == 0) {
            curArr[curArr.size - r] = v
            permutationAll(r - 1, curArr, visited or (1 shl i), result)
        }
    }
    return result
}
