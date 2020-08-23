package sort

import java.util.*
import kotlin.Comparator


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


    //1
    val personList = mutableListOf(Person("B", 2),
            Person("A", 2),
            Person("D", 1),
            Person("C", 3))
    personList.sortBy { it.name }
    personList.sortByDescending { it.name }
    personList.sortWith(compareBy({ it.age }, { it.name }))

    // comparator 1
    val c1: Comparator<Person> = Comparator { o1, o2 ->
        if (o2.age == o1.age) {
            o1.name.compareTo(o2.name)
        } else {
            o2.age - o1.age
        }
    }
    personList.sortWith(c1)

    // comparator 2
    class MyComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return if (p1.age == p2.age) {
                p1.name.compareTo(p2.name)
            } else {
                p2.age - p1.age
            }
        }
    }
    Collections.sort(personList, MyComparator())

    //todo: comparable vs comparator
    //java: ? extends Object，表示為Object或是Object的子類別，即為所有任意的類別。


}



