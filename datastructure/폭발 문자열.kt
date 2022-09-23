// https://www.acmicpc.net/problem/9935


fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val bomb = br.readLine().reversed()
    var stack = mutableListOf<Char>()
    val lastBombChar = bomb[bomb.length - 1]

    str.reversed().forEach {c ->
        stack.add(c)
        if (c == lastBombChar) {
            if (stack.size - bomb.length < 0) return@forEach
            if (stack.subList(stack.size - bomb.length, stack.size).joinToString("") == bomb) {
                stack = stack.subList(0, stack.size - bomb.length)
            }
        }
    }

    println(stack.reversed().joinToString("").ifEmpty { "FRULA" })
}