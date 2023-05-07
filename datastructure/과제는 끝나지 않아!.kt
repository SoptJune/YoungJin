// https://www.acmicpc.net/problem/17952

import java.util.*

var score = 0
val stack = Stack<Homework>()

fun main() {
    val N = readLine()!!.toInt()

    repeat(N) {
        val homework = readLine()!!.split(" ").map { it.toInt() }.toHomework()

        if (homework != null) {
            doHomework(homework)
        } else if (stack.isNotEmpty()) {
            doHomework(stack.pop())
        }
    }

    println(score)
}

fun List<Int>.toHomework() = if (this[0] == 0) null else Homework(this[1], this[2])

fun doHomework(homework: Homework) {
    homework.minute -= 1

    if (homework.minute > 0)
        stack.push(homework)
    else
        score += homework.score
}

data class Homework(
    val score: Int,
    var minute: Int
)