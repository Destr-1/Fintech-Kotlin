package ru.tinkoff.fintech.homework.lesson1

class Assistant(override val name: String, override val age: Int) : Educationer {
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

    fun lab(item: String) {
        println()
        println("Assistant check labarotory work \"$item\"")
    }
}