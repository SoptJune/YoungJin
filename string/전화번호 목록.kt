// https://www.acmicpc.net/problem/5052

fun main() {
    val br = System.`in`.bufferedReader()

    var numList: Array<String>
    repeat(br.readLine().toInt()) {
        numList = Array(br.readLine().toInt()) {
            br.readLine()
        }
        checkNumListValidation(numList.sorted())
    }
}

fun checkNumListValidation(numList: List<String>) {
    for (i in 1 until numList.size) {
        if (numList[i].startsWith(numList[i - 1])) {
            println("NO")
            return
        }
    }
    println("YES")
}
