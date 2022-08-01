import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    print(solution(br.readLine().lowercase()))
}

fun solution(str: String): String {
    val hashMap = hashMapOf<Char, Int>()
    for (c in str) {
        if (hashMap[c] == null) hashMap[c] = 1
        else hashMap[c] = hashMap[c]!! + 1
    }

    var max = -1
    var answer = 'A'
    hashMap.forEach {
        if (it.value == max) {
            answer = '?'
        } else if (it.value > max) {
            max = it.value
            answer = it.key
        }
    }

    return answer.uppercase()
}