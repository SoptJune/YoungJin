import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/4803

val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var parent: IntArray

fun main() {
    var testCase = 1
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0) break
        else if (m == 0) printResult(testCase++, n)
        else printResult(testCase++, getTreeCount(n, m))
    }
}

fun getTreeCount(n: Int, m: Int): Int {
    parent = IntArray(n + 1) { it }
    repeat(m) {
        val (v1, v2) = br.readLine().split(" ").map { it.toInt() }
        union(v1, v2)
    }

    val set = HashSet<Int>()
    for (i in 1..n) {
        val p = find(i)
        if (p > 0) set.add(p)
    }
    return set.size
}

fun union(x: Int, y: Int) {
    val v1 = find(x)
    val v2 = find(y)

    if(v1 == v2) {
        parent[v2] = v1
        parent[v1] = 0
    } else if (v1 < v2) {
        parent[v2] = v1
    } else {
        parent[v1] = v2
    }
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    val p = find(parent[x])
    parent[x] = p
    return p
}

fun printResult(num: Int, cnt: Int) {
    var msg = "Case $num: "
    msg += when (cnt) {
        0 -> "No trees."
        1 -> "There is one tree."
        else -> "A forest of $cnt trees."
    }
    println(msg)
}