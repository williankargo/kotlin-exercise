fun main() {
    var total = 0

    outer@ for (i in 1..9) {
        for (j in 1..9) {
            total += i * j

            if (total % 24 == 0) {
                println(total)
                continue@outer
            }
        }
        println("第${i}部份已結束")
    }

}