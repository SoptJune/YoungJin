import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/1920

lateinit var nums: List<Int>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine() // n
    nums = br.readLine().split(" ").map { it.toInt() }.sorted()

    br.readLine() // m
    br.readLine().split(" ").map { it.toInt() }.forEach {
        bw.write("${binarySearch(it)}\n")
    }

    bw.flush()
}

fun binarySearch(target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var mid = 0
    while (low <= high) {
        mid = (low + high) / 2
        if (nums[mid] < target) {
            low = mid + 1
        } else if (nums[mid] > target) {
            high = mid - 1
        } else {
            return 1
        }
    }
    return 0
}
