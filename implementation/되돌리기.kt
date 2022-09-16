// https://www.acmicpc.net/problem/1360

data class Cmd(
    val type: String,
    val value: String,
    val sec: Int
)

val cmds = ArrayList<Cmd>(50)
fun main() {
    repeat(readLine()!!.toInt()) {
        readLine()!!.split(" ").let { // 0: type, 1: value, 2: second
            cmds.add(Cmd(it[0], it[1], it[2].toInt()))
        }
    }
    runTextEditor()
}

fun runTextEditor() {
    var answer = ""
    var targetSec = 0
    val log = HashMap<Int, String>(50)
    cmds.forEach {
        when (it.type) {
            "type" -> {
                answer += it.value
            }
            "undo" -> {
                targetSec = it.sec - it.value.toInt() - 1 // undo하고 싶은 시점
                answer = log[targetSec] ?: getLastLog(log, targetSec) // targetSec에서의 로그를 가져옴, 만약 targetSec에 대한 로그가 존재하지 않는다면 해당 시점 이전의 가장 마지막 로그를 가져옴
            }
        }
        log[it.sec] = answer // 현재 시점에서 로그 남기기
    }
    println(answer)
}

/** targetSec 시점 이전의 가장 마지막 로그를 가져옴 */
fun getLastLog(log: HashMap<Int, String>, targetSec: Int): String {
    for (i in targetSec downTo 0)
        if (log[i] != null) return log[i]!!
    return ""
}