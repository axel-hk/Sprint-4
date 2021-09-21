package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "Не указано",
    val age: Int = 18,
    val averageRate: Double,
    val city: String = "Не указан",
    val specialization: String = "Не указана",
    val prevEducation: String? = "",
)
