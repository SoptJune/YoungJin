// https://www.acmicpc.net/problem/1700

var count = 0
lateinit var multiTab: Array<String>
lateinit var schedule: List<String>
val plugMap: HashMap<String, Int> = hashMapOf()
const val EMPTY = "empty"

fun main() {
    val (size, _) = readln().split(" ").map { it.toInt() }
    multiTab = Array(size) { EMPTY }
    schedule = readln().split(" ")
    schedule.forEach { p ->
        plugMap[p] = plugMap.getOrDefault(p, 0).plus(1)
    }

    schedule.forEachIndexed { idx, plug ->
        if (plug !in multiTab) { // 1. 플러그가 꽂혀있지 않은 경우
            val emptyPos = multiTab.indexOf(EMPTY)
            if (emptyPos >= 0) { // 1.1. 플러그를 꽂을 빈곳이 있다면 플러그 꽂기
                plugIn(emptyPos, plug)
            } else { // 1.2. 빈곳이 없다면 플러그 교체
                changePlug(idx, plug)
                count++
            }
        } else { // 2. 플러그가 꽂혀있는 경우
            plugIn(plug = plug)
        }
    }

    print(count)
}

fun changePlug(pos: Int, newPlug: String) {
    for (i in multiTab.indices) { // 1.2.1. 앞으로 꽂지 않을 플러그라면 멀티탭에서 제거하고 새 플러그를 꽂는다.
        val originPlug = multiTab[i]
        if (plugMap[originPlug] == 0) {
            plugIn(i, newPlug)
            return
        }
    }

    var lastPlug = multiTab[0] // 1.2.2. 꽂혀있는 플러그 중에 첫번째로 가장 늦게 나오는 플러그를 제거하고 새 플러그를 꽂는다.
    val plugSet = hashSetOf<String>()
    for (i in pos + 1 until schedule.size) {
        if (plugSet.size == multiTab.size) break
        if (schedule[i] in multiTab) {
            lastPlug = schedule[i]
            plugSet.add(lastPlug)
        }
    }

    plugIn(multiTab.indexOf(lastPlug), newPlug)
}

/** 해당 플러그를 스케줄링 처리 및 꽂으려고 하는 플러그가 멀티탭에 꽂혀있지 않다면 해당 포지션에 플러그를 꽂음 */
fun plugIn(pos: Int? = null, plug: String) {
    plugMap[plug] = plugMap.getOrDefault(plug, 0).minus(1)
    if (pos != null) multiTab[pos] = plug
}
