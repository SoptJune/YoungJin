fun main(args: Array<String>) {
    val heightList = IntArray(9) { readLine()?.toInt() ?: 0 }
    findSevenDwarfs(heightList)
}

fun findSevenDwarfs(heightList: IntArray) {
    val total = heightList.sum()

    for (i in 0..heightList.size - 2) {
        for (j in i + 1 until heightList.size) {
            if(total - heightList[i] - heightList[j] == 100) {
                heightList.filterIndexed { index, _ ->
                    index != i && index != j
                }.sorted().forEach { height ->
                    println(height)
                }
                return
            }
        }
    }
}