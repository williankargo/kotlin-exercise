package singleTon

//有時候，我們不希望我們的 class 是一個 Singleton, 但是我們又需要有一個靜態區塊，這時我們就需要 companion object

private const val wow = 4  //java: private final static int wow = 4 , 但用kotlin時不要去刻意想java的東西
const val wow2 = 5  //java: public final static int wow2 = 5
val wow3 = 6  //java: private final int wow2 = 5 但在kotlin中是默認public

// top-level class, 不依賴於其他class
class MyClass {
    companion object {
        var count: Int = -1

        //const: 只能在top-level 或 object 中使用，和val不同的是不會自動生成getter
        /**所以當定義常量時，出於效率考慮，我們應該使用const val方式，避免頻繁函式呼叫*/
        //1
        const val SOME_VALUE = 3  //const val = public static final

        //2
        @JvmField
        val SOME_VALUE2 = 3

        // val V.S. const
        val SOME_VALUE3 = 3

        fun typeOfCustomers(): String {
            return "Indian"
        }
    }

    var count2: Int = -1

    var count3 = wow
    //Kotlin private: 只会在声明它的文件内可见, 所以跟這裡的class無關
    //Kotlin public: 声明将随处可见


    fun typeOfCustomers2(): String {
        return "Indian2"
    }

}

fun main() {

    MyClass.count = 10
    MyClass.SOME_VALUE  // = 9 不能改變
    MyClass.SOME_VALUE3  //val & const val引用方法很像

    println(wow)
    println(wow2)
    println(wow3)

    MyClass.typeOfCustomers()

    var demo2 = MyClass()
    demo2.count2 = 12
    demo2.typeOfCustomers2()

}