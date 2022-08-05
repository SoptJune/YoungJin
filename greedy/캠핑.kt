import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 1
    while (true) {
        val (l, p, v) = br.readLine().split(" ").map { it.toInt() }
        if (l == 0) return
        println("Case $count: ${(v / p) * l + (v % p).coerceAtMost(l)}")
        count++
    }
}