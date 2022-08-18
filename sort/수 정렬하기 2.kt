import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
val numbers = IntArray(br.readLine().toInt()) {
    br.readLine().toInt()
}
val answer = mutableListOf<Int>()

fun main(args: Array<String>) {
    val sb = StringBuilder()
    heapSort(numbers.toMutableList())
    answer.forEach { num ->
        bw.write("$num\n")
    }

    bw.close()
    br.close()
}

fun heapSort(arr: MutableList<Int>) {
    var size = arr.size

    // 자식 노드를 가진 노드만 순회
    for (i in size / 2 - 1 downTo 0) {
        heapify(size, i)
    }

    // 가장 작은 요소(추출)와 아직 정렬되지 않은 부분의 마지막 요소를 교환 후 힙 재구성
    for (i in size - 1 downTo 0) {
        answer.add(numbers[0])
        numbers[0] = numbers[i]
        heapify(--size, 0)
    }
}

/** 최소힙 만들기 */
fun heapify(heapSize: Int, pIdx: Int) {
    var p = pIdx;
    val l = pIdx * 2 + 1;
    val r = l + 1

    if (l < heapSize && numbers[l] < numbers[p]) p = l
    if (r < heapSize && numbers[r] < numbers[p]) p = r
    if (pIdx != p) {
        val temp = numbers[pIdx]
        numbers[pIdx] = numbers[p]
        numbers[p] = temp
        heapify(heapSize, p)
    }
}