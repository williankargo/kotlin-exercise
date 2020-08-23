package Lambda

class Person {
    var name: String = ""
    var age: Int = -1

    fun startRun(){
        println("Now I am ready to run.")
    }
}

fun main() {
    var person = Person()

    // method 1
    with(person){
        name = "Peter"
        age = 23
    }

    // method 2, 這個可以用方法
    person.apply {
        name = "Peter"
        age = 23
    }.startRun()
}