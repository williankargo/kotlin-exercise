package Lambda

fun main() {


    val myNumbers: List<Int> = listOf(2, 3, 4, 6, 23, 90)

    // filter
    val mySmallNums = myNumbers.filter { v -> v < 10 }  //method 1
    val mySmallNums2 = myNumbers.filter { it < 10 }  //method 2

    for (num in mySmallNums) {
        println(num)
    }

    // map
    val mySquaredNums = myNumbers.map { it * it }  // num -> num * num

    for (num in mySquaredNums) {
        println(num)
    }

    // map & filter
    class Person(var age: Int, var name: String) {}

    var people = listOf<Person>(Person(10, "Sam"),
            Person(10, "Seed"), Person(10, "Amy"))
    var names = people.filter { it.name.startsWith("S") }.map { it.name }

    for (name in names) {
        println(name)
    }

    // some method
    val myNumbers2 = listOf(2, 3, 4, 6, 23, 90)

    val myPredicate = { num: Int -> num > 10 }

    val check1 = myNumbers2.all({ it > 10 })// Are all elements greater than 10?
    val check11 = myNumbers2.all(myPredicate)
    println(check1)

    val check2 = myNumbers2.any({ it > 10 })
    val check22 = myNumbers2.any(myPredicate)
    println(check2)

    val totalCount = myNumbers2.count { it > 10 }
    val totalCount2 = myNumbers2.count(myPredicate)
    println(totalCount)

    val num = myNumbers2.find { it > 10 }
    println(num)

}











