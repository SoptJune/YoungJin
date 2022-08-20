import java.io.BufferedReader
import java.io.InputStreamReader

// https://zion830.tistory.com/127

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val noHear = mutableSetOf<String>()
    val noSee = mutableSetOf<String>()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    repeat(n) { noHear.add(br.readLine()) }
    repeat(m) { noSee.add(br.readLine()) }

    val result = noHear.intersect(noSee)

    println(result.size)
    result.sorted().forEach { println(it) }
}