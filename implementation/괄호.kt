import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/9012

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = mutableListOf<Boolean>()

    repeat(br.readLine().toInt()) {
        result.add(checkVps(br.readLine()))
    }
    result.forEach { println(if (it) "YES" else "NO") }
}

fun checkVps(ps: String): Boolean {
    val stack = mutableListOf<Char>()
    for (c in ps) {
        if (c == '(') {
            stack.add(c)
        } else {
            if (stack.isNotEmpty() && stack.last() == '(') stack.removeLast()
            else return false
        }
    }

    return stack.size == 0
}