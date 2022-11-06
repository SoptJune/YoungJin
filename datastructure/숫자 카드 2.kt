import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/10816

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val myCard = hashMapOf<Int, Int>()

    br.readLine() // n
    br.readLine().split(" ").map { it.toInt() }.forEach {
        myCard[it] = myCard.getOrDefault(it, 0) + 1
    }

    br.readLine() // m
    br.readLine().split(" ").map { it.toInt() }.forEach {
        bw.write("${myCard[it] ?: 0} ")
    }

    bw.flush()
}
