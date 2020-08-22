package Generics

/** "*" and "Any" */


fun main() {

    fun acceptAnyList(list: List<Any?>) {}
    fun acceptStarList(list: List<*>) {}  // * == out Any?

    val listOfStrings= listOf("Hello", "Kotlin", "World")
    acceptAnyList(listOfStrings)  // List 自動轉成List<out Any?>
    acceptStarList(listOfStrings)

    fun acceptAnyArray(array: Array<Any?>) {}
    fun acceptStarArray(array: Array<*>) {}  // * == out Any?

    val arrayOfStrings = arrayOf("Hello", "Kotlin", "World")
    //acceptAnyArray(arrayOfStrings)  // Array 不會自動轉成Array<out Any?>
    acceptStarArray(arrayOfStrings)


}
