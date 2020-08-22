package Enum

enum class CurrencyType2 {
    USD, CNY, JPY, AUD, TWD
}

enum class CurrencyType(val chineseName: String,
                        val simpleExRate: Double) {
    USD("美元", 30.0),
    CNY("人民幣", 4.5),
    JPY("日圓", 0.3),
    AUD("澳幣", 20.0),
    TWD("臺幣", 1.0);  // 添加方法時需要加上分號

    //「toString」方法預設會回傳name屬性
    override fun toString() = "$chineseName ${super.toString()}"
}

class CurrentAccount(val id: String, val currencyType: CurrencyType, var balance: Double) {}

val ac1 = CurrentAccount("1", CurrencyType.USD, 3027.5)
val ac2 = CurrentAccount("2", CurrencyType.CNY, 400.0)
val ac3 = CurrentAccount("3", CurrencyType.JPY, 1800.0)

val accounts = listOf(ac1, ac2, ac3)


//ordinal代表的是該物件在類別中的順序
val ac11 = CurrentAccount("1", CurrencyType.USD, 100.0)
val ac12 = CurrentAccount("2", CurrencyType.AUD, 200.0)
val ac13 = CurrentAccount("3", CurrencyType.JPY, 300.0)
val ac14 = CurrentAccount("4", CurrencyType.CNY, 400.0)


//equals
fun findCurrencyTypeByName(name: String): CurrencyType? {
    for (type in CurrencyType.values()) {
        if (type.name.equals(name, true)) {
            return type
        }
    }
    return null
}

fun main() {
    for (ac in accounts) {
        var info = ""

        info += "幣別：${ac.currencyType.chineseName}\n"
        info += "餘額：${ac.balance}\n"
        info += "換算臺幣：${ac.balance * ac.currencyType.simpleExRate}\n"

        println(info)
    }


    //Enum類別提供了內建的屬性與方法
    // 取得名稱，印出：USD
    println(CurrencyType.USD.name)

    // 取得物件並比對，印出：true
    println(CurrencyType.valueOf("USD") == CurrencyType.USD)

    // 印出：美金 USD
    println(CurrencyType.USD.toString())


    //ordinal
    val accountss = listOf(ac11, ac12, ac13, ac14).sortedBy { it.currencyType.ordinal }

    for (ac in accountss) {
        println(ac.currencyType.name)
    }


    //values: 取得所有列舉出的物件
    val types: Array<CurrencyType> = CurrencyType.values()
    for(type in types){
        println(type.chineseName)
    }
}

















