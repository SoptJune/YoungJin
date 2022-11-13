import java.util.LinkedList

lateinit var progressList: LinkedList<Pair<Int, Int>>

fun main() {
    solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val answer = mutableListOf<Int>()
    progressList = LinkedList<Pair<Int,Int>>()
    progressList.addAll(progresses.mapIndexed { index, i ->
        Pair(i, speeds[index])
    })

    var day = 1
    while (progressList.isNotEmpty()) {
        val p = progressList.peek()
        if (p.first + p.second * day >= 100) {
            progressList.pop()
            answer.add(getCompletedFeatureCount(day))
        }
        day++
    }

    return answer.toIntArray()
}

fun getCompletedFeatureCount(day: Int): Int {
    var count = 1
    var progress = progressList.peek()
    while (progressList.isNotEmpty() && progress.first + progress.second * day >= 100) {
        progressList.pop()
        progress = progressList.peek()
        count++
    }
    return count
}
