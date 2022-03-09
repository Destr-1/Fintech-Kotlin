package ru.tinkoff.fintech.homework.lesson1

interface Educationer {
    val name: String
    var age: Int

    fun process() // общая деятельность

    fun training() // повышение квалификации

    fun knowledgeLevelInfo()
    fun knowledgeLevel() : Int
    fun newKnowledgeLevel(level: Int)
    fun addKnowledgeLevel(level:Int):Int

    fun educationerInfo() = "Information about educationer".personPrint()

    fun String.personPrint() {
        println()
        println(this)
        println("Name: $name \tAge: $age")
    }
}
