package DataStructures

fun main() {

    /**Any 是所有人的爸爸，Nothing是所有人的兒子*/
    /** Collections */
    //唯讀：宣告集合時需同時定義元素
    // 唯讀List
    val list1: List<Int> = listOf<Int>()
    val list2: List<Int> = listOf(80)
    val list3: List<Int> = listOf(1, 2, 3)
    //list3[0] = 666  不能修改

    /**Array(可以修改，但大小是固定的), List(不能修改，但mutableList大小是可以變的)*/
    // Collections跟Array類似，都是可以儲存許多資料的一種物件。差別在於Collections的容量不需定義，也沒有上限。
    val array1: Array<Int> = arrayOf(1, 2, 3)
    array1[0] = 666  //可以修改

    // 唯讀Set
    val set1: Set<Int> = setOf()
    val set2: Set<Int> = setOf(80)
    val set3: Set<Int> = setOf(1, 2, 3)

    // 唯讀Map
    val map1: Map<String, Int> = mapOf()
    val map2: Map<String, Int> = mapOf("Anna" to 10)
    val map3: Map<String, Int> =
            mapOf("Anna" to 10, "Bonnie" to 20, "Cynthia" to 30)

    //可讀：宣告集合時，未必要定義初始元素，且之後允許更改元素，和元素個數沒有關係
    // 本質為Java的ArrayList
    val list11: MutableList<Int> = mutableListOf()
    list11.add(666)
    list11.remove(666)
    list11.clear()
    list11.size
    val list22: MutableList<Int> = mutableListOf(2, 1, 3)  // mutableList not only implements from "List"
    list22[0] = 4


    // 本質為Java的LinkedHashSet
    val set11: MutableSet<Int> = mutableSetOf()
    val set22: Set<Int> = mutableSetOf(2, 1, 3)

    // 本質為Java的LinkedHashMap
    val map11: MutableMap<String, Int> = mutableMapOf()
    map11.put("1", 666)
    map11.remove("1")
    map11.get("1")
    map11.clear()
    val map22: Map<String, Int> =
            mutableMapOf("Anna" to 10, "Bonnie" to 20, "Cynthia" to 30)


    //走訪元素
    //List
    // 使用for each
    val girls = listOf("Anna", "Bonnie", "Cynthia")
    for (name in girls) {
        println(name)
    }
    // 使用索引(indices)
    val boys = listOf("Darcy", "Edison")
    for (i in boys.indices) {
        println(boys[i])
    }

    //Set
    //使用for each
    val girls2 = setOf("Bonnie", "Anna")
    for (name in girls2) {
        println(name)
    }
    //使用withIndex
    val boys2 = setOf("Darcy", "Edison")
    for ((i, v) in boys2.withIndex()) {
        println("${i + 1}. $v")
    }

    //Map
    // 接收key與value
    var girls3 = mapOf("Anna" to 406, "Bonnie" to 408)
    for ((k, v) in girls3) {
        println("$k: $v")
    }
    // 接收Entry物件
    val boys3 = mapOf("Darcy" to 430, "Edison" to 414)
    for (entry in boys3) {
        println("${entry.key}: ${entry.value}")
    }


}