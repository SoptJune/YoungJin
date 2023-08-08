// https://www.acmicpc.net/problem/14719

fun main() {
    readln()
    var total = 0
    val h = mutableListOf<Int>()
    val originH = readln().split(" ").map { it.toInt() }
    
    var minH = 0
    var maxH = originH[0]
    var prevH = originH[0]
    
    for (i in 1 until originH.size) {
        val isHole = (prevH < originH[i] && prevH < maxH)
        setMinMax(originH[i], maxH) { min, max -> maxH = max; minH = min }
        if (isHole) {
            for (j in h.size - 1 downTo 0) {
                if (h[j] >= minH) break
                total += (minH - h[j])
                h[j] = minH
            }
        }
        
        prevH = originH[i]
        h.add(originH[i])
    }

    print(total)
}

inline fun setMinMax(h1: Int, h2: Int, setMinMax: (Int, Int) -> Unit) {
    if (h1 < h2) setMinMax(h1, h2)
    else setMinMax(h2, h1)
}
