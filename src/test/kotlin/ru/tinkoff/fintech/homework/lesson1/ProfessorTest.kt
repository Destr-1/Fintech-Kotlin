package ru.tinkoff.fintech.homework.lesson1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfessorTest {

    @Test
    fun `профессор на курсах повыш квалиф увелич знание на 5`() {
        val professor = Professor("Иванов", 54)
        assertEquals(100, professor.knowledgeLevel())
        professor.training()
        assertEquals(105, professor.knowledgeLevel())
    }
}