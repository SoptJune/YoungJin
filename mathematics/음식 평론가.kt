// https://www.acmicpc.net/problem/1188

fun main() {
    val (n, m) = System.`in`.bufferedReader().readLine().map { it.digitToInt() }
    println(m - gcd(n, m))
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}
