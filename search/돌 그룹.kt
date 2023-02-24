// https://www.acmicpc.net/problem/12886

import java.util.LinkedList

val visited = mutableMapOf<String, Boolean>()
val q = LinkedList<Int>()
var total = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
    total = x + y + z

    if (total % 3 != 0) {
        print(0)
        return
    }

    q.add(x)
    q.add(y)
    visited["$x, $y"] = true
    bfs()
}


fun bfs() {
    var x: Int
    var y: Int
    var z: Int

    while (q.isNotEmpty()) {
        x = q.pop()
        y = q.pop()
        z = total - x - y

        if (x == y && y == z) {
            print(1)
            return
        }

        calculateXY(x, y)
        calculateXY(y, z)
        calculateXY(z, z)
    }
    print(0)
}


fun calculateXY(x: Int, y: Int) {
    val a: Int
    val b: Int

    if (x < y) {
        a = x + x
        b = y - x
    } else if (y < x) {
        a = y + y
        b = x - y
    } else {
        return
    }

    if (visited["$a, $b"] == true) return
    q.add(a)
    q.add(b)
    visited["$a, $b"] = true
}