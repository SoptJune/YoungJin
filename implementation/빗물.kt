// https://www.acmicpc.net/problem/14719

import kotlin.math.abs

fun main() {
    readln()

    var total = 0
    var diffInfos = mutableListOf<DiffInfo>()
    val heights = readln().split(" ").map { it.toInt() }

    var maxHeight = heights[0]
    var prevHeight = heights[0]

    for (i in 1 until heights.size) {
        if (isHole(prevHeight, heights[i], maxHeight)) {
            val standard = heights[i].coerceAtMost(maxHeight)
            for (idx in diffInfos.size - 1 downTo 0) {
                if (diffInfos[idx].height < standard) {
                    total += (standard - diffInfos[idx].height)
                    diffInfos[idx] = DiffInfo(standard, diffInfos[idx].diff - standard)
                } else {
                    break
                }
            }
        }

        val curDiff = heights[i] - maxHeight
        if (curDiff > 0) maxHeight = heights[i]
        diffInfos.add(DiffInfo(heights[i], abs(curDiff)))
        prevHeight = heights[i]
    }

    print(total)
}

fun isHole(x: Int, h1: Int, h2: Int) = (x < h1 && x < h2)

data class DiffInfo(
    var height: Int,
    var diff: Int
)