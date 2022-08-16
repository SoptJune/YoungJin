import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

// https://www.acmicpc.net/problem/2810

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numOfSeats = br.readLine().toInt()
    val seats = br.readLine().replace("LL", "L")
    print(min(numOfSeats, seats.length + 1))
}