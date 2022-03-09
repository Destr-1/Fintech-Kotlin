package ru.tinkoff.fintech.homework.lesson1

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

//import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck

@ExtendWith(MockKExtension::class)
class LessonTest {
    @MockK(relaxUnitFun = true)
    lateinit var professor: Professor
    var assistant = mockk<Assistant>()

    @BeforeEach
    fun startUp() {
        every { professor.process() } returns Unit // println("Работает профессор")
        every { professor.name } returns "Профессор-заглушка"

        every { assistant.process() } returns Unit
        every { assistant.training() } returns Unit //println("Повышение квалификации ассистента")
        every { assistant.knowledgeLevel() } returns 1000
        every { assistant.lab(any()) } returns Unit
        every { assistant.knowledgeLevelInfo() } throws IllegalStateException("Cannot print LevelInfo")
        every { assistant.newKnowledgeLevel(any()) } throws IllegalStateException("Cannot set new knowledge Level")
        every { assistant.age } returns 10
        every { assistant.name } returns "Ассистент-заглушка "
        every {assistant.addKnowledgeLevel(any())} returns 1000
        every {assistant.addKnowledgeLevel(10)} returns 100
        every {assistant.addKnowledgeLevel(30)} returns 300

    }

    @Test
    fun `тестируем передачу объекта-заглушки mock professor`() {
        val lecture = Lesson(professor, 100)
        lecture.lessonInfo()
        verify { professor.process() }
    }

    @Test
    fun `тестируем передачу объекта-заглушки mock assistant`() {
        val lecture = Lesson(assistant, 200)
        lecture.lessonInfo()
        lecture.lessonInfo()
        assertAll(
            { verify(exactly = 2) { assistant.process() } },
            { verify(exactly = 2) { assistant.name } },
            { assertEquals(10, assistant.age) },
            {verify(exactly = 2) {assistant.addKnowledgeLevel(10)} },
            {verify(exactly = 2) {assistant.addKnowledgeLevel(30)} },
            {verify(exactly = 6) {assistant.addKnowledgeLevel(any())} },
            { assertEquals(100,assistant.addKnowledgeLevel(10))}
        )
    }
}
