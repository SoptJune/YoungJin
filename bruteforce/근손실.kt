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
    val test = permutation(kits.indices.toList())

    for (order in test)
        if (isValidOrder(order))
            ans++

    print(ans)
}

fun isValidOrder(order: List<Int>): Boolean  {
    var total = WEIGHT
    for (idx in order) {
        if (total + kits[idx] - K >= WEIGHT) total += kits[idx]
        else return false
    }
    return true
}

fun permutation(sub: List<Int>, fin: List<Int> = listOf()): List<List<Int>> {
    return if (sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(sub - it, fin + it) }
}
