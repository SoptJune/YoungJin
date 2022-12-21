// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=kotlin

fun main() {
    println(solution1(10, 2))
}

fun solution1(brown: Int, yellow: Int): IntArray {
    var width: Int

    for (length in 1..yellow) {
        if (yellow % length != 0) continue
        width = yellow / length
        if (2 * width + 2 * length + 4 == brown) return intArrayOf(width + 2, length + 2)
    }

    return intArrayOf()
}

fun solution2(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    var y = 0

    for (x in 1..yellow) {
        if (yellow % x != 0) continue
        y = yellow / x
        if (2 * x + 2 * y + 4 == brown) {
            answer = x.getWidthNLength(y)
            break
        }
    }
    return answer
}

fun Int.getWidthNLength(x: Int) = if (this >= x) intArrayOf(this + 2, x + 2) else intArrayOf(x + 2, this + 2)