// https://www.acmicpc.net/problem/1334

fun main() {
    var num = System.`in`.bufferedReader().readLine().toBigInteger() + 1.toBigInteger()
    while (true) {
        if (isPalindrome(num.toString().toCharArray())) return println(num)
        else num++
    }
}

fun isPalindrome(arr: CharArray): Boolean {
    for (i in 0 until arr.size / 2)
        if (arr[i] != arr[arr.size - 1 - i]) return false
    return true
}