// https://www.acmicpc.net/problem/16918

data class Bomb(
    var status: Char,
    var time: Int
)

var bombs: MutableList<MutableList<Bomb>> = mutableListOf()
fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c, n) = br.readLine().split(" ").map { it.toInt() }
    for (row in 0 until r) {
        bombs.add(mutableListOf())
        for (ch in br.readLine()) bombs[row].add(Bomb(ch, 0))
    }

    var sec = 1
    val flag: MutableList<MutableList<Boolean>> = mutableListOf()
    while (sec < n) {
        sec++
        when (sec % 2) {
            0 -> installBombs(r, c, sec)
            1 -> uninstallBombs(r, c, sec)
        }
    }
    printBombs()
}

/** 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치함 */
fun installBombs(r: Int, c: Int, s: Int) {
    for (row in 0 until r) {
        for (col in 0 until c) {
            if (bombs[row][col].status == ('O')) continue
            bombs[row][col].apply {
                status = 'O'
                time = s
            }
        }
    }
}

/** 3초 전에 설치된 폭탄이 제거됨 */
fun uninstallBombs(r: Int, c: Int, s: Int, flag: MutableList) {
    for (row in 0 until r) {
        flag.add(mutableListOf())
        for (col in 0 until c) {
            flag[row].add(bombs[row][col].status == 'O' && s - bombs[row][col].time == 3)
        }
    }

    for (row in 0 until r) {
        for (col in 0 until c) {
            if (!flag[row][col]) continue
            bombs[row][col].status = '.'
            if (row > 0) bombs[row - 1][col].status = '.'
            if (row < r - 1) bombs[row + 1][col].status = '.'
            if (col > 0) bombs[row][col - 1].status = '.'
            if (col < c - 1) bombs[row][col + 1].status = '.'
        }
    }
}

fun printBombs() {
    for (row in bombs) {
        for (bomb in row) print(bomb.status)
        println()
    }
}