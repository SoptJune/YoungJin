import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
val n = br.readLine().toInt()
var recursionCount = 0; val dpCount = n - 2

fun main(args: Array<String>) {
    recursion(n)
    print("$recursionCount $dpCount")
}

fun dp(n: Int): Int {
    val f = IntArray(n + 1) { 0 }
    f[1] = 1; f[2] = 1
    for (i in 3..n)
        if (f[i] == 0) f[i] = f[i - 1] + f[i - 2]
    return f[n]
}

fun recursion(n: Int): Int {
    if (n == 1 || n == 2) {
        recursionCount++
        return 1
    }
    return recursion(n - 1) + recursion(n - 2)
}