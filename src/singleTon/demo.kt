package singleTon

//singleTon meaning: there exits only one object for this class by default
object CustomersData {

    var count: Int = -1  // == static int count

    fun typeOfCustomers(): String {  // == static String typeOfCustomers(){}
        return "Indian"
    }

    //support almost everythings
}

//normal case
class CustomersData2 {

    var count: Int = -1

    fun typeOfCustomers(): String {
        return "Indian"
    }
}

fun main() {

    //singleTon case
    CustomersData.count = 98
    CustomersData.typeOfCustomers()
    println(CustomersData.count)


    //normal case
    var Sdemo = CustomersData2()
    Sdemo.count = 100
    Sdemo.typeOfCustomers()
    println(Sdemo.count)


}