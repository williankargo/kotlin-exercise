package DataStructures

fun main() {
    //ByteArray、IntArray、DoubleArray等
    val scores = IntArray(3)

    //有明確的值
    val scores2 = intArrayOf(68, 69, 70)

    //print elements
    //由陣列提供索引範圍
    for (i in scores2.indices) {
        println(scores2[i])
    }

    //建立指定長度，元素為null，（String）並非基本資料型態
    val scores3 = arrayOfNulls<String>(5)

    //使用「arrayOf」方法，不需定義泛型類別，Kotlin會根據元素的資料型態自動決定
    val scores4 = arrayOf("Anna", "Bonnie", "Cynthia", "Darcy", "Edison")

    val names = arrayOf("Anna", "Bonnie", "Cynthia", "Darcy", "Edison")
    for ((i, value) in names.withIndex()) {  //類似key-value概念
        println("${i + 1}. ${value.toUpperCase()}")
    }

    //二維陣列
    val names2 = arrayOf(
            arrayOf("Anna", "Peter", "Derek"),
            arrayOf("Bob", "Darcy")
    )
    println(names2[1][0])

    //ex
    fun findName(names: Array<Array<String>>, target: String): Boolean {
        var isFound = false

        outer@ for (i in names.indices) {
            for (j in names[i].indices) {
                if (names[i][j] == target) {
                    isFound = true
                    println("${target}的位置在：$i,$j")
                    break@outer
                }
            }
        }
        return isFound
    }


    //vararg:傳入不限數量的同型態參數,方法中只能有一個可變長度參數
    fun printNumbers(vararg numbers: Int) {
        for (number in numbers) {
            println(number)
        }
    }

    printNumbers(10, 20, 30)

    val array = intArrayOf(10, 20, 30)
    printNumbers(*array)  //*:spread operator
    
}