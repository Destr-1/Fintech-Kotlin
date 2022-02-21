package ru.tinkoff.fintech.homework.lesson1

class Professor(override val name: String, override val age: Int) : Educationer {
    private var knowledgeLevel = 100
    override fun process() {
        "Professor: ".personPrint()
        print("teaches computer science ")
    }

    override fun training() {
        knowledgeLevel += 5
    }

    override fun knowledgeLevelInfo() {
        "Professor: ".personPrint()
        println("has knowledgeLevel = $knowledgeLevel")
    }

    fun lecture(count: Int) {
        println("Professor give a lecture for $count students")
    }
}