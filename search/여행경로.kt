// https://school.programmers.co.kr/learn/courses/30/lessons/43164?language=kotlin

fun main() {
    println(solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))))
}

lateinit var ticketList: Array<Array<String>>
lateinit var visited: Array<Boolean>
val routeList = mutableListOf<String>()

fun solution(tickets: Array<Array<String>>): Array<String> {
    ticketList = tickets
    visited = Array(ticketList.size) { false }
    dfs("ICN", "ICN", 0)
    routeList.sort()

    return routeList[0].split(", ").toTypedArray()
}

fun dfs(start: String, route: String, count: Int) {
    if (count == ticketList.size) {
        routeList.add(route)
        return
    }

    for (i in ticketList.indices) {
        if (start == ticketList[i][0] && !visited[i]) {
            visited[i] = true
            dfs(ticketList[i][1], route + ", " + ticketList[i][1], count + 1);
            visited[i] = false
        }
    }
}