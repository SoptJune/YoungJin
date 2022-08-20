import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 0

    repeat(br.readLine().toInt()) {
        if (checkerGroupWord(br.readLine())) count++
    }

    print(count)
}

fun checkerGroupWord(word: String): Boolean {
    val alphabets = hashSetOf<Char>()
    var lastChar = word[0]
    for (c in word) {
        if (alphabets.contains(c)) {
            if (lastChar == c) alphabets.add(c)
            else return false
        } else {
            alphabets.add(c)
        }
        lastChar = c
    }
    return true
}