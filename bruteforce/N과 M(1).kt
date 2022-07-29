fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = IntArray(m)
    val visited = BooleanArray(n + 1)

    fun backTrack(index: Int = 0) {
        if (index == m) {
            println(arr.joinToString(" "))
            return
        }

        for (i in 1..n) {
            if (visited[i]) continue
            arr[index] = i
            backTrack(index + 1)
            visited[i] = false
        }
    }

    backTrack()
}