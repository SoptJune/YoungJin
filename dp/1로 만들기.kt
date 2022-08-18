import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    var count = IntArray(n + 1)

    for (i in 2..n) {
        count[i] = count[i - 1] + 1
        if (i % 2 == 0) count[i] = minOf(count[i], 1 + count[i / 2])
        if (i % 3 == 0) count[i] = minOf(count[i], 1 + count[i / 3])
    }
    print(count[n])
}