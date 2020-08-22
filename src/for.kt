fun main() {

    //1
    var str = "Today is Monday"
    for (char in str) {
        print(char)
    }

    //2
    val from = 0
    val to = 10
    for (count in from..to) {
        print(count)
    }

    for (i in 0..10 step 2) {
        print(i)  // print 10
    }

    //3
    for (i in  0 until 10){
        print(i)  // not print 10
    }

}
