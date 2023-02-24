//https://www.acmicpc.net/problem/1253

fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine()
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0
    var l: Int; var r: Int; var sum: Int
    
    for (i in nums.indices) {
        l = 0
        r = nums.size - 1
        while (l < r) {
            sum = nums[l] + nums[r]
            if (sum < nums[i]) {
                l++
            } else if (sum > nums[i]) {
                r--
            } else {
                if (l != i && r != i) {
                    count++
                    break
                }
                if (l == i) l++
                else r--
            }
        }
    }

    print(count)
}