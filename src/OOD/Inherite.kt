package OOD

import java.time.LocalDate

//要被繼承的類別則要加上 open 關鍵字
open class User(_account: String, _password: String) {
    var account: String = _account.toLowerCase()
    private var password: String = _password
    public var name: String? = null
    val createdOn: LocalDate = LocalDate.now()
    var birthday: LocalDate? = null

    fun changePassword(_newPassword: String) {
        this.password = _newPassword
    }

    //父類方法供override
    open fun whoAreYou() {
        println("I'm user.")
    }
}

//要繼承一個類別使用冒號 : 達成
class Customer2(_account: String, _password: String) : User(_account, _password) {

    //透過 getter 可以在取值時，基於其它邏輯條件決定要回傳的值
    val isVIP: Boolean //= false
        get() {
            if (birthday == LocalDate.now()) {
                return true
            }
            return false
        }

    //子類override父類方法
    override fun whoAreYou() {
        println("I'm customer.")
    }
}

class Employee(_account: String, _password: String) : User(_account, _password) {
    var title: String = ""
    private var salary: Int = 0

    //子類override父類方法
    override fun whoAreYou() {
        super.whoAreYou()  //super呼叫父類方法
        println("And employee")
    }
}

fun main() {

    var cust = Customer2("A", "123")
    println(cust.account)  //繼承來自主類別 User
    println(cust.whoAreYou())  //因為這個fun沒有宣告要return什麼東西，所以自動return kotlin.Unit

    println("=======")

    var employee = Employee("B", "555")
    println(employee.account)
    println(employee.title)
    println(employee.whoAreYou())
}




