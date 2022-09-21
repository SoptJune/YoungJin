// https://www.acmicpc.net/problem/9375

fun main() {
    val br = System.`in`.bufferedReader()
    lateinit var clothesMap: HashMap<String, Int>

    repeat(br.readLine().toInt()) { // 테스트 케이스 입력
        clothesMap = hashMapOf()

        repeat(br.readLine().toInt()) { // 의상 입력
            val (_, type) = br.readLine().split(" ")
            if (clothesMap.containsKey(type))
                clothesMap[type] = clothesMap[type]!!.plus(1)
            else
                clothesMap[type] = 1
        }

        println(getNumOfClothesCombinations(clothesMap))
    }
}

fun getNumOfClothesCombinations(clothesMap: HashMap<String, Int>): Int {
    if (clothesMap.size == 0) return 0

    var count = 1
    clothesMap.forEach {
        count *= it.value + 1 // +1은 해당 type의 의상은 입지 않는 경우를 추가한 것
    }

    return count - 1 // -1은 어떠한 의상도 입지 않는 경우를 제외한 것
}