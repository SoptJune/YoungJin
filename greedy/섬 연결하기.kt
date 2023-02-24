// https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=kotlin

fun main() {
    println(
        solution1(
            4,
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(0, 2, 2),
                intArrayOf(1, 2, 5),
                intArrayOf(1, 3, 1),
                intArrayOf(2, 3, 8),
            )
        )
    )
}

lateinit var parents: Array<Int>

fun solution1(n: Int, costs: Array<IntArray>): Int {
    costs.sortBy { it[2] }
    parents = Array(n) { it }
    var ans = 0

    costs.forEach { cost ->
        val p0 = findParent(cost[0])
        val p1 = findParent(cost[1])

        if (p0 != p1) {
            if (p0 < p1) parents[p1] = p0
            else parents[p0] = p1
            ans += cost[2]
        }
    }

    return ans
}

fun findParent(node: Int): Int {
    if (parents[node] == node) return node
    return findParent(parents[node])
}

fun solution2(n: Int, costs: Array<IntArray>): Int {
    costs.sortBy { it[2] }
    var i = 1
    var ans = costs[0][2]
    val routes = mutableListOf(mutableSetOf(costs[0][0], costs[0][1]))

    while (i < costs.size && routes[0].size < n) {
        var state = 0 // 두 노드 모두 방문한 적 없는 상태
        routes.forEach { route ->
            if (route.contains(costs[i][0]) && route.contains(costs[i][1])) {
                state = 1 // 두 노드를 방문했으며 두 노드가 이미 이어진 상태
                return@forEach
            } else if ((route.contains(costs[i][0]) && !route.contains(costs[i][1])) || (!route.contains(costs[i][0]) && route.contains(
                    costs[i][1]
                ))
            ) {
                state = 2 // 둘 중 한 노드만 경로에 포함된 상태
                route.add(costs[i][0])
                route.add(costs[i][1])
            }
        }

        if (state == 0) {
            routes.add(mutableSetOf(costs[i][0], costs[i][1])) // 두 노드를 방문한 적이 없다면 새 경로 추가
        } else if (state == 1) { // 두 노드를 모두 방문했고, 두 노드가 이어져 있는 경우 패스~
            continue
        } else { // 두 노드 중 한 노드만 기존 경로에 포함되어있는 경우, 위에서 경로를 업데이트 해주었고, 업데이트에 따라 기존 경로들을 합칠 수 있으면 합쳐준다.
            var j = 0
            while (j < routes.size - 1) {
                if (routes[j].intersect(routes[j + 1]).isNotEmpty()) { // 중복된 노드가 있어 경로를 이을 수 있는 경우,
                    routes[j].union(routes[j + 1])
                    routes.removeAt(j + 1)
                }
                j++
            }
        }

        ans += costs[i][2]
        i++
    }

    return ans
}