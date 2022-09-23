// https://www.acmicpc.net/problem/9935

fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val bomb = br.readLine()
    val stack = mutableListOf<Char>()
    val lastBombChar = bomb[bomb.length - 1]

    str.forEach { c ->
        stack.add(c)
        if (stack.size - bomb.length < 0) return@forEach
        if (c == lastBombChar && stack.subList(stack.size - bomb.length, stack.size).joinToString("") == bomb) {
            repeat(bomb.length) { stack.removeLast() }
        }
    }

    println(stack.joinToString("").ifEmpty { "FRULA" })
}
