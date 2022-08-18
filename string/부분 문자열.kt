import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/16916

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    print(kmp(br.readLine(), br.readLine()))
}

fun makeTable(pattern: String): IntArray {
    val table = IntArray(pattern.length); var j = 0
    for (i in 1 until pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) j = table[j - 1]
        if (pattern[i] == pattern[j]) table[i] = ++j
    }

    return table
}

fun kmp(origin: String, pattern: String): Int {
    val table = makeTable(pattern); var j = 0

    for (i in origin.indices) {
        while (j > 0 && origin[i] != pattern[j]) j = table[j - 1]
        if (origin[i] == pattern[j]) {
            if (j == pattern.length - 1) return 1
            else j++
        }
    }

    return 0
}