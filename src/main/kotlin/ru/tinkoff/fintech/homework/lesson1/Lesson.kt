package ru.tinkoff.fintech.homework.lesson1

class Lesson(val person: Educationer, val classroomNumber: Int) {

    fun lessonInfo() {
        person.process()
        print("at classroom № $classroomNumber")
    }
}