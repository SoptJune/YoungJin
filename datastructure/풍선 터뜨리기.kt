import java.util.ArrayDeque
import java.lang.Math.abs

// https://www.acmicpc.net/problem/2346

data class Balloon(
    val id: Int,
    val num: Int
)

val br = System.`in`.bufferedReader()
fun main() {
    solution1()
    solution2()
}

fun solution1() {
    val balloons = mutableListOf<Balloon>()
    br.readLine()
    br.readLine().split(" ").mapIndexed { id, num ->
        balloons.add(Balloon(id + 1, num.toInt()))
    }

    var idx = 0
    var movement = 0

    while (true) {
        print("${balloons[idx].id} ")
        movement = balloons[idx].num
        balloons.removeAt(idx)
        if (balloons.isEmpty()) break

        if (movement > 0) movement--
        idx += movement

        while (idx !in balloons.indices) {
            if (idx < 0) idx += balloons.size
            idx %= balloons.size
        }
    }
}

fun solution2() {
    val balloons = ArrayDeque<Balloon>()
    var movement: Int

    br.readLine()
    br.readLine().split(" ").mapIndexed { id, num ->
        balloons.addFirst(Balloon(id + 1, num.toInt()))
    }

    while (balloons.isNotEmpty()) {
        print("${balloons.last().id} ")
        movement = balloons.last().num
        balloons.removeLast()

        if (balloons.isEmpty()) break
        if (movement > 0) {
            for (i in 0 until movement - 1)
                balloons.addFirst(balloons.removeLast())
        } else {
            for (i in 0 until abs(movement))
                balloons.addLast(balloons.removeFirst())
        }
    }
}