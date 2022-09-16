import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/1431

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val serials = mutableListOf<String>()

    repeat(br.readLine().toInt()) {
        serials.add(br.readLine())
    }

    serials.sortedWith(compareBy({ it.length }, { it.sumOf { it.digitToIntOrNull() ?: 0 } }, { it }))
        .forEach { serial ->
            println(serial)
        }
}