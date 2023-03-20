// https://www.acmicpc.net/problem/1669

import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val (X, Y) = br.readLine().split(" ").map { it.toInt() }

    if (X == Y) {
        print(0)
        return
    }

    val gap = (Y - X)
    val N = sqrt(gap.toDouble()).toInt()
    if (N * N == gap) print(2 * N - 1)
    else if (gap <= N * N + N) print(2 * N)
    else print(2 * N + 1)
}