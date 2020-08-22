fun main() {

    val chineseScore = mapOf("Anna" to 78, "Bonnie" to 56, "Darcy" to 72, "Edison" to 68)
    val englishScore = mapOf("Anna" to 77, "Bonnie" to 57, "Darcy" to 27, "Edison" to 87)
    val mathScore = mapOf("Anna" to 81, "Bonnie" to 51, "Darcy" to 71, "Edison" to 18)

    printTranscript(chineseScore, englishScore, mathScore)
}


fun printTranscript(vararg scores: Map<String, Int>) {  //可以接收多個Map
    val students = mutableSetOf<String>()
    for (score in scores) {
        students.addAll(score.keys)  //addAll 會把加入的東西拆開以個別加入
        print("This is Score keys: " + score.keys)  //如果沒有拆開就會是以下結果
    }

    val transcript = sortedMapOf<String, Int>()

    for (stu in students) {
        var total = 0

        for (score in scores) {
            total += score.getOrDefault(stu, 0)
        }

        transcript[stu] = total
    }

    for ((k, v) in transcript) {
        println("$k: $v")
    }
}