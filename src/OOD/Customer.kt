package OOD

/**1*/
class Customer(_account: String, _password: String) {  //primary constructor

    //優先執行,在主要建構式結束後執行
    init {
        println("Init account: ${_account}")
    }

    var account: String = _account.also(::println)
    var password: String = _password.also(::println)
    var isVIP: Boolean = false.also(::println)

    //second constructor
    constructor(_account: String, _password: String, _isVIP: Boolean) : this(_account, _password) {
        println("Second Constructor: $_account")
        this.isVIP = _isVIP
    }
}


/**2*/
class Student constructor(_stuId: String,
                          _firstName: String,
                          _lastName: String) {
    var id = _stuId
        set(value) {  //override set
            field = if (value == "") "none" else value
        }

    var fullName = "$_firstName $_lastName"
        get() {  //override get
            return if (field.isEmpty()) "(Not provided)" else field //field語法代表原資料的意思
        }

    var gender = false
    constructor(stuId: String, fullName: String, gender: Boolean)
            : this(stuId, fullName, "") {  //通過this()呼叫primary constructor, _lastName傳入的東西不會用到
        this.gender = gender
        println("Sub constructor finished.")
    }
}


/**3*/
class Course constructor(id: String,
                         name: String,
                         credit: Int) {
    val id: String
    var name: String
    var credit: Int
    init {
        this.id = id
        this.name = if (name.isEmpty()) "(Not provided)" else name
        this.credit = if (credit < 0) 0 else credit
        println("Main constructor finished.")
    }

    constructor(id: String, name: String)
            : this(id, name, 0) {
        println("Sub constructor finished.")
    }
}


fun main() {
    /**1*/
    var custA = Customer("A", "123")
    var custB = Customer("B", "123", true)
    println("${custA.account} ${custA.isVIP}")
    println("${custB.account} ${custB.isVIP}")

    /**2*/
    var demo1 = Course("A","Peter",123)
    var demo2 = Course("B","Kate")  //還會在print一次 "Main constructor finished."
}