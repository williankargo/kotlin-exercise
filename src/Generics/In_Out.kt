package Generics


/**interface*/
// out: 你只能讀我，不能寫我 / 能 『父 <= 子』 子類單向賦值給父類
interface Production<out T> {
    fun produce(): T
}

// in: 你只能寫我，不能讀我 / 能『子 <= 父』 父類單向賦值給子類
interface Consumer<in T> {
    fun consume(item: T)
}

// invariant
interface ProductionConsumer<T> {
    fun produce(): T
    fun consume(item: T)
}

/**type*/
open class Food  // grandpa
open class FastFood : Food()  // father
class Burger : FastFood()  // child


/**Production*/
class FoodStore : Production<Food> {
    override fun produce(): Food {
        println("Produce Food")
        return Food()
    }
}

class FastFoodStore : Production<FastFood> {
    override fun produce(): FastFood {
        println("Produce Fast Food")
        return FastFood()
    }
}

class InOutBurger : Production<Burger> {
    val number = 87
    override fun produce(): Burger {
        println("Produce burger")
        return Burger()
    }
}

fun testWrite(here: Production<Burger>) {}


//Production test
val production1: Production<Food> = FoodStore() //Production<Food>
val production2: Production<Food> = FastFoodStore()  //Production<FastFood>
val production3: Production<Food> = InOutBurger()  //Production<Burger>
//val production4: Production<Burger> = FoodStore() //Production<Food> error


/**Consumer*/
class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println("Eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat fast food")
    }
}

class American : Consumer<Burger> {
    val number = 87
    override fun consume(item: Burger) {
        println("Eat burger")
    }
}

fun testWrite2(here: Consumer<Burger>) {}

//Consumer test
val consumer1: Consumer<Burger> = Everybody()  //Consumer<Food>
val consumer2: Consumer<Burger> = ModernPeople()  //Consumer<FastFood>
val consumer3: Consumer<Burger> = American()  //Consumer<Burger>
//val consumer4: Consumer<Food> = American()  //Consumer<Burger>


/**Normal case*/
class Peter : ProductionConsumer<Food> {

    val number = 87
    override fun produce(): Food {
        return Food()
    }

    override fun consume(item: Food) {
    }

}


fun main() {
    //out:
    //testWrite(production3)  不能被寫入fun
    print(production3.produce())  //可以讀取
    //print(production3.name) 不能讀interface額外的參數

    //in:
    testWrite2(consumer3)  //可以被寫入fun
    //print(consumer3.consume()) 不能讀取

    //normal case
    val normalCase = Peter()
    print(normalCase.number)
}












