import java.util.ArrayDeque
import java.lang.Math.abs

// https://www.acmicpc.net/problem/2346

data class Balloon(
    val id: Int,
    val num: Int
)

fun main() {
    val br = System.`in`.bufferedReader()
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