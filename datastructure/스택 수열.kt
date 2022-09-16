// https://www.acmicpc.net/problem/1874

fun main() {
    val br = System.`in`.bufferedReader()

    val nums = mutableListOf<Int>()
    val res = mutableListOf<Int>()
    var ans = ""

    repeat(br.readLine().toInt()) {
        nums.add(br.readLine().toInt())
    }

    var num = 1
    res.add(num)

    while (nums.isNotEmpty()) {
        if (num == nums.first()) {
            nums.removeFirst()
            ans += "+\n-\n"
            num++
        } else if (num < nums.first()) {
            res.add(num++)
            ans += "+\n"
        } else {
            if (nums.first() == res.last()) {
                res.removeLast()
                nums.removeFirst()
                ans += "-\n"
            } else {
                print("NO")
                return
            }
        }
    }
    print(ans)
}
