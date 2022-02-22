package ru.tinkoff.fintech.homework.lesson1

fun main() {
    val professor = Professor("Старый Иванов", 64)
    val assistant = Assistant("Молодой Сидоров", 24)

    val educationers = listOf(professor, assistant)

    educationers.forEach {
        it.educationerInfo()
    }


    println()
    print("Information about knowledgeLevel:")
    educationers.forEach {
        it.knowledgeLevelInfo()
    }
    println()
    println("refresher training...")
    professor.training()
    assistant.training()
    println()
    print("new knowledgeLevel:")
    professor.knowledgeLevelInfo()
    assistant.knowledgeLevelInfo()

    val lecture = Lesson(professor, 100)
    val labWork = Lesson(assistant, 345)
    val lessons = listOf(lecture, labWork)
    lessons.forEach {
        println()
        it.lessonInfo()
    }
    println()

    professor.lecture(45)
    assistant.lab("Konlin")
}
