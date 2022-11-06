import kotlin.math.max
import kotlin.math.min

// https://www.acmicpc.net/problem/1018

fun main() {
    val br = System.`in`.bufferedReader()
    val chess = ArrayList<CharArray>()
    val (row, col) = br.readLine().split(" ").map { it.toInt() }

    repeat(row) {
        chess.add(br.readLine().toCharArray())
    }

    var min = 64
    var countBlack: Int
    var countWhite: Int

    // 1. 8X8 체스판탐색
    for (r in 0 until row - 7) {
        for (c in 0 until col - 7) {
            countWhite = 0; countBlack = 0

            // 2. 다시 칠해야할 정사각형 수의 최소값 구하기
            for (i in r until r + 8) {
                for (j in c until c + 8) {
                    if ((i + j) % 2 == 0) {
                        if (chess[i][j] == 'W') countBlack++
                        else countWhite++
                    } else {
                        if (chess[i][j] == 'W') countWhite++
                        else countBlack++
                    }
                }
            }
            min = min(min, min(countWhite, countBlack))
        }
    }

    println(min)
}
