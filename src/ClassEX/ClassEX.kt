package ClassEx

import java.sql.Struct

//https://ithelp.ithome.com.tw/articles/10204643

//如果不使用var或val，則參數就只是參數，它不會直接成為物件的屬性。
//Kotlin的建構子可以在類別定義時一起定義建構子，為主要建構子
class ClassEX constructor(val id: String, var name: String, var credit: Int) {
}


//次要建構式就像方法的「多載」（overloading）
class Student constructor(stuId: String,
                          firstName: String,
                          lastName: String) {
    val id = stuId
    var fullName = "$firstName $lastName"
    var gender = false

    constructor(stuId: String, fullName: String, gender: Boolean)
            : this(stuId, fullName, "") {
        this.gender = gender
        println("Sub constructor finished.")
    }
}

fun main() {
    var demo = Student("123","Hsieh","Peter")
    print(demo.id)
}
