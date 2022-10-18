// https://www.acmicpc.net/problem/1334

fun main() {
    val num = System.`in`.bufferedReader().readLine().toBigInteger() + 1.toBigInteger()
    
    // solution 1
    val arr = num.toString().map { it.digitToInt() }.toMutableList()
    if (num < 10.toBigInteger()) println(num)
    else println(makePalindrome(arr))

    /* solution 2
    while (true) {
        if (isPalindrome(num.toString().toCharArray())) return println(num)
        else num++
    } */
}

// solution 2
fun makePalindrome(arr: MutableList<Int>): String {
    // 가운데 수 기준으로 앞자리 숫자가 뒷자리 수보다 크거나 같을 때 뒷자리 수를 앞자리수와 같게 만든다.
    if (arr.subList(0, arr.size / 2).joinToString("").toBigInteger() >= arr.subList(arr.size / 2 + 1, arr.size)
            .joinToString("").toBigInteger()
    ) {
        for (i in 0 until arr.size / 2)
            arr[arr.size - 1 - i] = arr[i]
    } else {
        var mid = arr.size / 2
        if (arr.size % 2 == 0) mid--
        var sum = 0

        for (i in mid downTo 0) {
            sum = arr[i] + 1
            if (sum > 9) {
                if (i > 0) {
                    arr[i] = 0
                    arr[i - 1]++
                } else {
                    arr[i] = sum
                }
            } else {
                arr[i]++
                break
            }
        }

        for (i in 0 until arr.size / 2)
            arr[arr.size - 1 - i] = arr[i]
    }
    return arr.joinToString("")
}

// solution 1
fun isPalindrome(arr: CharArray): Boolean {
    for (i in 0 until arr.size / 2)
        if (arr[i] != arr[arr.size - 1 - i]) return false
    return true
}