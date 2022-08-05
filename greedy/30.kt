import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbers = br.readLine().toCharArray().sortedDescending()
    print(if (numbers.last() == '0' && numbers.sumOf { it.digitToInt() } % 3 == 0) numbers.joinToString("") else -1)
}