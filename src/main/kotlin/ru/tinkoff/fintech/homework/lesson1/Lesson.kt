package ru.tinkoff.fintech.homework.lesson1

class Lesson(val person: Educationer, val classroomNumber: Int) {

    fun lessonInfo() {
        print(person.name)
        person.process()
        println("at classroom № $classroomNumber")
        println(person.addKnowledgeLevel(10))
        println(person.addKnowledgeLevel(30))
        println(person.addKnowledgeLevel(50))
    }
}