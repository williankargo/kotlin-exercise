//basic
class Productt(val id: String, var name: String, var price: Int) {}

data class DataProduct(val id: String, var name: String, var price: Int) {}


fun main() {
    val product1 = Productt("BK001", "數學複習講義", 320)

    /**資料類別的主要建構式，規定參數必須都用var與val來宣告。意即參數都會成為類別的屬性。*/
    val product2 = DataProduct("BK001", "數學複習講義", 320)

    println(product1.toString())  //Productt@3b9a45b3
    println(product2.toString())  //DataProduct(id=BK001, name=數學複習講義, price=320)


    /**copy: 資料類別的物件可以進行複製*/
    val product3 = product2.copy()

    //直接改constructor
    val product4 = product2.copy(id = "AC002", name = "MATH")

    println(product3)
    println(product4)

    /**component*/

    //BJ001
    println(product2.component1())
    //印出：數學複習講義
    println(product2.component2())
    //320
    println(product2.component3())

    /**解構*/
    val (productId, productName, productPrice) = product2
    // 印出：BK001
    println(productId)
    // 印出：數學複習講義
    println(productName)
    // 印出：320
    println(productPrice)


    /**equals與hashCode方法*/
    //屬性值相同的物件，equals方法的結果為true，而hashCode方法的結果也一致。

    val product11 = DataProduct("BK001", "數學複習講義", 320)
    val product22 = DataProduct("BK001", "數學複習講義", 320)
    // 印出：true
    println(product11.equals(product22))
    println(product22.equals(product11))
    // 印出：-1538320945
    println(product11.hashCode())
    println(product22.hashCode())
    //「equals」方法可替換成「==」語法。而Kotlin另外提供的「===」語法是用來比較兩個物件的記憶體位址。
}


//override and Any? and as
class Demo(val id: String, var name: String, var price: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false

        other as Demo
        if (id != other.id) return false
        if (name != other.name) return false
        if (price != other.price) return false

        return true

        /**as(type casting) & is(type checking):*/
        // "foo is X" is the equivalent of "foo instanceof X"
        // "foo as X" is the equivalent of "((X) foo)"
        //Kotlin has a safe cast as?. If it cannot be casted, it will return null instead.
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}


