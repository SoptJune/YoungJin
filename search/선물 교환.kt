// https://www.acmicpc.net/problem/1889

lateinit var students: Array<Student>
fun main() {
    // 1. 각 학생별 idx값, 받은 선물 갯수, 선택한 학생 두명의 idx값 정보를 초기화
    val br = System.`in`.bufferedReader()
    students = Array(br.readLine().toInt()) { idx -> Student(idx) }
    students.forEach { s ->
        val (one, two) = br.readLine().split(" ").map { it.toInt() - 1 }
        students[one].numOgGift++
        students[two].numOgGift++
        s.studentPair = Pair(one, two)
    }

    // 2. 선물을 2개 미만으로 받은 학생을 표시
    val failure = mutableListOf<Student>()

    students.forEach { student ->
        if (student.numOgGift < 2) failure.add(student)
    }

    // 3. failure에 의해 선물을 받지 못하는 학생들을 탐색
    var idx: Int
    while (failure.isNotEmpty()) {
        idx = failure.removeLast().idx // 선물을 2개 미만으로 받은 학생 a를 선택
        students[idx].studentPair.let { ids -> // 해당 학생이 선택한 두명의 학생은 학생 a에게 선물을 받지 못함 -1
            if (--students[ids.first].numOgGift == 1) failure.add(students[ids.first]) // 받은 선물의 갯수가 2 - 1 = 1이 된 경우, failure에 새롭게 추가
            if (--students[ids.second].numOgGift == 1) failure.add(students[ids.second])
        }
    }
    
    students.filter { it.numOgGift == 2 }.also { ans ->
        println(ans.count())
        println(ans.map { it.idx + 1 }.joinToString(" "))
    }
}

data class Student(
    val idx: Int,
    var numOgGift: Int = 0,
    var studentPair: Pair<Int, Int> = Pair(-1, -1)
)