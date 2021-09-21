package ru.sber.functional

import java.util.function.Predicate

class StudentsGroup {

    lateinit var students: List<Student>

    init {
       students = listOf(Student("Alex", "Annenkov", age = 20,  averageRate = 4.3),
                        Student("Maria", "Fedotova", age = 19, averageRate = 4.7 ),
                        Student("Ivan", "Ivanov", averageRate = 5.0))
    }

    fun filterByPredicate(predicate: (Student) -> Boolean): List<Student> {
        val group = students.filter(predicate)
        return group
    }


}

fun main(){
    val group = StudentsGroup()
    val oldstudents = group.filterByPredicate { it.age > 18 }
    for(student:Student in oldstudents){
        println(student.lastName +" " + student.firstName)
    }
    val studentsWithGoodMarks = group.filterByPredicate { it.averageRate > 4.5 }
    for(student:Student in studentsWithGoodMarks){
        println(student.lastName +" " + student.firstName)
    }
}
