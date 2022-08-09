import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/1181

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val words = mutableSetOf<String>()
    repeat(br.readLine().toInt()) {
        words.add(br.readLine())
    }

    words.sortedWith(compareBy({ it.length }, { it })).forEach {
        bw.write("$it\n")
    }

    bw.close()
    br.close()
}