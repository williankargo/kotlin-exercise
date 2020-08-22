package OOD

import java.time.LocalDate

class Cusomer2(_account: String, _password: String) {
    var account: String = _account.toLowerCase()
    private var password: String = _password  //只能在此class中使用get set
    var name: String? = null  //todo:look here

    var isVIP: Boolean = false //isVIP在class外是唯讀
        private set            //如果直接用private就不能讀了

    var birthday: LocalDate? = null
    val createOn: LocalDate = LocalDate.now()

    fun changePassword(_newPassword: String) {
        this.password = _newPassword
    }
}

fun main() {
    var cust = Cusomer2("A", "123")

    cust.name = "Jack"  //todo:look here
    cust.birthday = LocalDate.now()
    println("Name: ${cust.name}, Is VIP? ${cust.isVIP}")
    println("Birthday is on ${cust.birthday}")
    cust.changePassword("321")

    print("cust.name " + cust.name) //todo: the result is "cust.name Jack"
    //error
    //println("Password is ${cust.password}")
    //cust.isVIP = true
}
