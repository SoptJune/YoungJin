import java.io.BufferedReader
import java.io.InputStreamReader

// https://www.acmicpc.net/problem/1259

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val numStr = br.readLine()
        if (numStr == "0") return
        else isPalindrome(numStr)
    }
}

fun isPalindrome(str: String) {
    for (i in 0 until str.length / 2) {
        if (str[i] == str[str.length - 1 - i]) {
            continue
        }
        else {
            println("no")
            return
        }
    }
    println("yes")
    return
}