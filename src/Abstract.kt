abstract class Product(val id: String, var name: String, var price: Int, var unit: String) {
    abstract val TYPE: String

    //abstract可以initialize property
    val demo = "wow"
    abstract fun getBasicInfo(): String
    abstract fun getExtraInfo(): String
    fun getDetail() = "${getBasicInfo()}\n${getExtraInfo()}"
}

class Book(id: String, name: String, price: Int, unit: String, var author: String, var publisher: String) : Product(id, name, price, unit) {

    override val TYPE = "書籍"

    override fun getBasicInfo() = "$TYPE $name $$price"

    override fun getExtraInfo() = "作者： $author' $publisher"
}

class Clothes(id: String, name: String, price: Int, unit: String, var size: String, var material: String) : Product(id, name, price, unit) {

    override val TYPE = "衣物"

    override fun getBasicInfo() = "$TYPE $id $name $$price/$unit"

    override fun getExtraInfo() = "材質：$material $size"
}

// 建立抽象類別的object物件
val book = object : Product("BK001", "數學複習講義", 320, "本") {
    override val TYPE = "書籍"
    override fun getBasicInfo() = "$TYPE $name $$price"
    override fun getExtraInfo() = "作者：許小明，東東出版社"
}


fun main() {
    val book = Book("BX001", "數學複習講義", 320, "本", "許明", "品寬出版社")
    val clothes = Clothes("BX002", "襪子", 320, "雙", "M", "毛")

    println(book.getDetail())
    println()
    println(clothes.getDetail())
}