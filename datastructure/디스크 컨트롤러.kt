import java.util.PriorityQueue

// https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=kotlin

fun main() {
    println(solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))))
}

fun solution(jobs: Array<IntArray>): Int {
    jobs.sortBy { it[0] }
    val pq = PriorityQueue<IntArray> { a, b -> a[1] - b[1] }

    var ans = 0
    var end = 0
    var idx = 0
    var job = intArrayOf()

    while (true) {
        while (idx < jobs.size && jobs[idx][0] <= end)
            pq.add(jobs[idx++])

        if (pq.isEmpty()) {
            if (idx >= jobs.size) break
            else end = jobs[idx][0]
        } else {
            job = pq.poll()
            ans += (end - job[0] + job[1])
            end += job[1]
        }
    }

    return ans / jobs.size
}