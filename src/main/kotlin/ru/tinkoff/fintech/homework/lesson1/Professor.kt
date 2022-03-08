package ru.tinkoff.fintech.homework.lesson1

class Professor(override val name: String, override var age: Int) : Educationer {
    private var knowledgeLevel = 100
    override fun process() {
        "Professor: ".personPrint()
        print("teaches computer science ")
    }

    override fun training() {
        knowledgeLevel += 5
    }

    override fun newKnowledgeLevel(level: Int) {
        knowledgeLevel += level
    }

    override fun knowledgeLevelInfo() {
        "Professor: ".personPrint()
        println("has knowledgeLevel = $knowledgeLevel")
    }

    override fun knowledgeLevel() = knowledgeLevel

    fun lecture(count: Int) {
        println()
        println("Professor give a lecture for $count students")
    }
}