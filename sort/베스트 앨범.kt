// https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=kotlin

data class Music(
    val id: Int,
    val genres: String,
    val playCount: Int,
)

fun main() {
    println(solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500)))
}

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val album = mutableListOf<Int>()
    val musics = mutableListOf<Music>()

    // 1. 음악 리스트를 생성, 이때 하나의 음악 정보는 고유번호, 장르, 재생 횟수로 구성된다.
    genres.forEachIndexed { idx, genre ->
        musics.add(Music(idx, genre, plays[idx]))
    }

    // 2. 음악리스트를 장르별로 나눈다. 이때 장르는 속한 음악이 많이 재생된 장르순으로 정렬한다.
    val musicByGenre =
        musics.groupBy { it.genres }.values.sortedByDescending { musicOfTheGenre -> musicOfTheGenre.sumOf { music -> music.playCount } }

    // 3. 장르 내 음악은 재생 수가 높은 음악순으로 정렬하고, 정렬된 장르 내 음악에서 최대 2개의 음악을 앨범에 수록한다.
    musicByGenre.forEach { musicOfTheGenre ->
        // 1. forEachIndexed 사용
        musicOfTheGenre.sortedByDescending { music -> music.playCount }.forEachIndexed { index, music ->
            if (index <= 1) album.add(music.id)
        }
        
        // 2. take 사용
        // album.addAll(musicOfTheGenre.sortedByDescending { music -> music.playCount }.take(2).map { music -> music.id })
    }

    return album.toIntArray()
}