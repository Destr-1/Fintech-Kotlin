package ru.tinkoff.fintech.homework.lesson1

class Assistant(override val name: String, override var age: Int) : Educationer {
    private var knowledgeLevel = 30
    override fun process() {
        "Assistant: ".personPrint()
        print("checks laboratory work ")
    }

    override fun training() {
        knowledgeLevel += 10
    }

    override fun knowledgeLevelInfo() {
        "Assistant: ".personPrint()
        println("has knowledgeLevel = $knowledgeLevel")
    }

    override fun knowledgeLevel() = knowledgeLevel
    override fun addKnowledgeLevel(level:Int) = knowledgeLevel + level
    override fun newKnowledgeLevel(level: Int) {
        knowledgeLevel += level
    }

    fun lab(item: String) {
        println()
        println("Assistant check labarotory work \"$item\"")
    }
}