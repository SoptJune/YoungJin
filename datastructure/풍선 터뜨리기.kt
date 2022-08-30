import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Balloon(
    val id: Int,
    val num: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val balloons = mutableListOf<Balloon>()

    br.readLine().toInt()
    br.readLine().split(" ").mapIndexed { id, num ->
        balloons.add(Balloon(id + 1, num.toInt()))
    }

    var idx = 0
    var targetIdx = 0
    var target = balloons[idx]

    while (balloons.size > 1) {
        targetIdx = (idx + balloons[idx].num) % balloons.size
        if (targetIdx < 0) targetIdx += balloons.size

        bw.write("${balloons[idx].id} ")
        target = balloons[targetIdx]
        balloons.removeAt(idx)
        idx = balloons.indexOf(target)
    }

    bw.write("${balloons[0].id} ")
    bw.flush()
}