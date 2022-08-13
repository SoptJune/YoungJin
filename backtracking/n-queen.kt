import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

//https://www.acmicpc.net/problem/9663

val br = BufferedReader(InputStreamReader(System.`in`))
val size = br.readLine().toInt()
val chess = IntArray(size)
var count = 0

fun main(args: Array<String>) {
    backtrack(0)
    print(count)
}

fun backtrack(currentRow: Int) {
    // 1. 퀸이 배치된 행수가 총 N개가 되면, count값을 1씩 증가
    if (currentRow == size) {
        count++
        return
    }

    // 2. 그렇지 않은 경우, 현재 행에서 모든 열을 검사
    for (i in chess.indices) {
        // 2.1. 행 위치에 열 값을 할당
        chess[currentRow] = i
        // 2.2.1. 현재 퀸의 위치가 유망한 경우, 다음 행 검사
        if (isPromising(currentRow)) backtrack(currentRow + 1)
        // 2.2.2. 유망하지 않은 경우, 반복문 진행
    }
}

fun isPromising(currentRow: Int): Boolean {
    // 같은 열에 있는 지 검사 : queen[currentRow(현재 행)] == chess[j(행)]
    // 대각 선 상에 존재하는 지 검사 : 행거리 == 열거리 -> currentRow - ㅓ == abs(chess[currentRow] - chess[j])
    for (j in 0 until currentRow) if (chess[currentRow] == chess[j] || currentRow - j == abs(chess[currentRow] - chess[j])) return false
    return true
}