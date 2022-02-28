package ru.tinkoff.fintech.homework.lesson1

interface Educationer {
    val name: String
    val age: Int

    fun process() // общая деятельность

    fun training() // повышение квалификации

    fun knowledgeLevelInfo()

    fun educationerInfo() = "Information about educationer".personPrint()

    fun String.personPrint() {
        println()
        println(this)
        println("Name: $name \tAge: $age")
    }
}




