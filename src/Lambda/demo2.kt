package Lambda

fun main() {

    val program = Program2()
    val myLambda: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    program.addTwoNumbers(2, 7, myLambda)  // method 1
    program.addTwoNumbers(3, 8, { x, y -> x + y }) // method 2
    program.addTwoNumbers(4, 8) { x, y -> x + y } // method 3

    var result = 0
    val program3 = Program3()
    program3.addTwoNumbers(2, 7) { x, y -> result = x + y } //可以透過涵式來改變涵式外的變數
    println(result)

    var program4 = Program4()
    program4.reverseAndDisplay("hello") { it.reversed() } //單一param才能用
}

class Program2 {
    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int) -> Int) {
        val result = action(a, b)
        println(result)
    }
}

class Program3 {
    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int) -> Unit) {
        action(a, b)
    }
}

class Program4 {
    fun reverseAndDisplay(str: String, myFunc: (String) -> String) {
        var result = myFunc(str)
        print(result)
    }
}