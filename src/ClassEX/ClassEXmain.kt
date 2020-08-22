package ClassEx

fun main() {

    //不需要寫new
    val course2 = ClassEX("GN001", "English", 8)

    //Kotlin的類別不需自行宣告get與set方法，它們會隱含地建立
    // 用Kotlin的思維來看，id, name, credit本來就是public, 所以可以直接呼叫
    //get:
    println("Id: ${course2.id}")
    println("Name: ${course2.name}")
    println("Credit: ${course2.credit}")

    //set:
    course2.name = "Basic English"
    print("Name: ${course2.name}")

}