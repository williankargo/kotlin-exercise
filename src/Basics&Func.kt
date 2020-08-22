fun main() {

    //Basic
    val id: String = "10346000"
    var name: String = "Vincent"
    var age: Int = 23
    var isActive: Boolean = true

    val timeMills = 60 * 1000.toLong()
    val interestStr = (25000 * 0.03 * 9 / 12).toString()

    //function
    fun showMemberInfo(id: String, name: String): Unit { //Unit == void, 可省略
        println("Id" + id)
        println("Name" + name)
    }

    fun clacInterest(money: Int, rate: Double, month: Int): Double {
        return money * rate * month / 12
    }
    clacInterest(month = 9, rate = 0.03, money = 420000000)

    //若只要一個程式敘述就能回傳，我們能省略回傳值型態與大括號
    fun clacInterest2(money: Int, rate: Double, month: Int = 12) = money * rate * month / 12

    //字串模板
    val namee = "Peter"
    val info = "$namee : ${clacInterest2(30000, 0.03)}"
    print(info)

    //null
    //如果宣告一個可為空的變數，就需要在變數類型後方加上「?」
    //?：做 null check 後，不為空的話再執行
    var cellphoneBrand: String? = "Google"     // ? means nullable , !!：堅持不會是空值，執行就是了
    cellphoneBrand = null    // acceptable

    val mostLoveBrand: String? = "PAWKO"

    fun myPrint(strings: String?) {
        val result = strings?.reversed()    // 可能為null
        print("I love $result the most.")
    }

    myPrint(mostLoveBrand)
    myPrint(null)

    //回傳空值涵式
    fun addCoolWords(words: String): String {
        return "The $words is very cool!!"
    }

    fun addSuperCoolWords(words: String): String? {
        return "The $words is super cool!!"
    }

    val reversedWords = addCoolWords("Penguin").reversed()

    // It needs safe call
    val reversedSuperWords = addSuperCoolWords("Now")?.reversed() //返回的Stirng?做null check


}