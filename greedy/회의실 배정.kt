// https://www.acmicpc.net/problem/1931

data class MeetingInfo(
    val start: Int,
    var end: Int
)

fun main() {
    val br = System.`in`.bufferedReader()
    val meetingList = Array(br.readLine().toInt()) { MeetingInfo(0, 0) }

    for (i in meetingList.indices) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        meetingList[i] = MeetingInfo(start, end)
    }

    meetingList.sortWith(compareBy<MeetingInfo> { it.end }.thenBy { it.start })

    var count = 0
    var lastEndTime = 0
    for (i in meetingList.indices) {
        if (meetingList[i].start >= lastEndTime) {
            count++
            lastEndTime = meetingList[i].end
        }
    }

    println(count)
}