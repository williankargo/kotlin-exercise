package sort


fun main() {

    /**List*/
    val intList = mutableListOf(1, 2, 6, 3, 7, 9, 4)

    // Acs
    print(intList.sorted())

    intList.sort()
    print(intList)

    // Desc
    intList.sortDescending()

    // Reverse
    intList.reverse()

    val pairList = mutableListOf(1 to "A", 2 to "B", 5 to "C", 3 to "D")

    // sortBy
    pairList.sortBy { it.first }
    pairList.sortBy { it.second }

    // sortWith
    pairList.sortWith(compareBy({ it.second }, { it.first }))  //先排second, 再排first

    /**class*/
    data class Person(var name: String, var age: Int)

    // Comparator
//    class MyComparator : Comparator<>

    //1
    val personList = mutableListOf(Person("B", 2),
            Person("A", 2),
            Person("D", 1),
            Person("C", 3))
    personList.sortBy { it.name }
    personList.sortByDescending { it.name }
    personList.sortWith(compareBy({ it.age }, { it.name }))

    // comparator
    personList.sortWith(
            Comparator { o1, o2 ->
                if (o2.age == o1.age) {
                    o1.name.compareTo(o2.name)
                } else {
                    o2.age - o1.age
                }
            }
    )

    // comparable
//    Collections.sort(personalList,)


}



