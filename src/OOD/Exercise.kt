package OOD

fun initCourses(): Map<String, Course3> {
    val courses = listOf(
            Course3("IT001", "計算機概論1", 3),
            Course3("IT002", "計算機概論2", 3),
            Course3("IT003", "計算機概論3", 3),
            Course3("IT004", "計算機概論4", 3),
            Course3("IT005", "計算機概論5", 3)
    )

    //todo
    var demo = courses.map { it.id to it }  //it variable is an implicit parameter in lambda.
    var ans = demo.toMap()
    return ans

    /**Pair*/ //相当于简化版的 Map.Entry 类
    val p1 = 1 to "Hello"
    // 等价于 val p1 = 1.to("Hello")
    val p2 = p1 to "World"
    // p1: Pair<Int, String>
    // p2: Pair<Pair<Int, String>, String>
}

class Course3(val id: String, name: String, credit: Int) {
    var name = if (name.isEmpty()) "Not provided" else name
    var credit = if (credit < 0) 0 else credit
}

class Student3(val id: String, firstName: String, lastName: String) {
    var fullName: String = "$firstName $lastName"

}

class CourseSelection(var year: Int, var semester: Int, var student: Student3) {
    var courses: MutableSet<Course3> = mutableSetOf()

    fun addCourse(vararg selectedCourses: Course3?) {
        val courses = selectedCourses.filterNotNull()
        this.courses.addAll(courses)
    }

    fun generateDetail(): String {
        var detail = ""
        var totalCredit = 0

        detail += "${year}學年度第${semester}學期選課清單\n"
        detail += "學生：${student.id} ${student.fullName}\n"

        detail += "課程編號\t\t課程名稱\t\t學分數\n"
        for (c in courses) {
            detail += "${c.id}\t\t${c.name}\t\t${c.credit}\n"
            totalCredit += c.credit
        }

        detail += "總學分：$totalCredit\n"

        return detail
    }
}

fun main() {
    val courses = initCourses()

    val peterSelection = CourseSelection(107, 2, Student3("1056001", "Peter", "Hsieh"))

    peterSelection.addCourse(courses["IT001"], courses["IT002"], courses["IT003"], courses["IT004"], courses["IT005"])

    println(peterSelection.generateDetail())
}