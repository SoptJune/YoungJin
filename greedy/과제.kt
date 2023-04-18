// https://www.acmicpc.net/problem/13904

val N = readln().toInt()
val ans = Array(1_001) { 0 }

fun main() {
    val homeworkList = Array(N) {
        readln().split(" ").map { it.toInt() }
    }

    homeworkList.sortByDescending { it[1] } // 과제 점수 높은순으로 정렬
    homeworkList.forEach {
        completeHomework(it[0], it[1])
    }

    println(ans.sum()) // 제출한 과제의 점수 총합을 출력
}

fun completeHomework(deadline: Int, score: Int) {
    if (ans[deadline] == 0) // 해당 마감일에 제출한 과제가 하나도 없다면 과제 제출(과제는 하루에 하나만 제출 가능)
        ans[deadline] = score
    else { // 해당 마감일에서 1씩 감소시키면서 최대한 과제를 늦게 제출
        for (day in deadline - 1 downTo 1) {
            if (ans[day] == 0) {
                ans[day] = score
                return
            }
        }
    }
}
