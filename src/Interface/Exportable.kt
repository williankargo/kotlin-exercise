package Interface

/**實作一個介面*/
interface Exportable {
    //Property initializers are not allowed in interfaces
    var exportLocation: String

    fun getFileName(): String
    fun getExportContent(): String
    fun getExportPath() = "$exportLocation\\${getFileName()}"

    //若有數個介面或父類別定義了相同的方法，那麼類別在同時繼承或實作時便會發生衝突。
    fun printStatus() {
        println("輸出路徑：${getExportPath()}")
    }
}

// override interface
class Product(val id: String, var name: String, var price: Int, var unit: String) : Exportable {

    val demo = 87

    override var exportLocation = "\\product"

    override fun getFileName(): String {
        return "$id $name.txt"
    }

    override fun getExportContent(): String {
        return "$id\n$name\n單價:$price/$unit"
    }
}


// override interface
class Article(val id: String, var title: String, var content: String, var author: String) : Exportable {
    override var exportLocation = "\\article"

    override fun getFileName(): String {
        return "$title-$author"
    }

    override fun getExportContent(): String {
        return "$title\n$content"
    }
}


/**實作多個介面*/
interface DBEntity {
    fun isFieldValid(): Boolean

    //若有數個介面或父類別定義了相同的方法，那麼類別在同時繼承或實作時便會發生衝突。
    fun printStatus() {
        println("屬性檢查通過：${isFieldValid()}")
    }
}

class Product2(val id: String, var name: String, var price: Int, var unit: String) : Exportable, DBEntity {
    override var exportLocation: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun getFileName(): String {
        TODO("Not yet implemented")
    }

    override fun getExportContent(): String {
        TODO("Not yet implemented")
    }

    override fun isFieldValid() = name.isNotEmpty() && price >= 0 && unit.isNotEmpty()

    override fun printStatus() {
        super<DBEntity>.printStatus()
        super<Exportable>.printStatus()
    }
}


/**介面繼承介面*/
interface DBDocument : DBEntity, Exportable {
    val id: String
    override abstract fun printStatus()
}

class Product3(override val id: String, var name: String, var price: Int, var unit: String) : DBDocument {
    override var exportLocation: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun getFileName(): String {
        TODO("Not yet implemented")
    }

    override fun getExportContent(): String {
        TODO("Not yet implemented")
    }

    override fun getExportPath(): String {
        return super.getExportPath()
    }

    override fun isFieldValid(): Boolean {
        TODO("Not yet implemented")
    }

    override fun printStatus() {
        println("物件狀態")
    }
}


/**介面的物件, 不用再另建class*/
val course = object : Exportable {

    val id = "IT001"
    val name = "Chinese"

    override var exportLocation = "\\course"

    override fun getFileName() = "$id $name"

    override fun getExportContent() = "編號：$id\n課程名稱:$name\n學分數:3"

    fun test() = "test"

}


fun main() {
    val product = Product("BK001", "數學複習講義", 320, "本")
    val article = Article("AR002", "Kotlin教學系列",
            "這系列文章，希望能幫助學過Java的人上手Kotlin的語法...",
            "Vincent")
    print(product.demo)  //test for 額外增加interface沒有的東西
    exportFile(product)
    println(exportFile(article))
    exportFile(course)

    product.printStatus()
    course.getFileName()
    exportFile(course)
}

fun exportFile(item: Exportable) {
    println("${item.getExportPath()} 已經儲存")
    println(item.getExportContent())
}











