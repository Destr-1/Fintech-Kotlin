package ru.tinkoff.fintech.homework.lesson1

import io.mockk.MockKException
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class AssistantTest {
    @MockK(relaxUnitFun = true)
    lateinit var assistant: Assistant

    @Test
    fun `тестируем assistant с помощью mock`() {
        every { assistant.knowledgeLevel() } returns 80
        assistant.training()
        assertEquals(80, assistant.knowledgeLevel())

        assistant.newKnowledgeLevel(50)
        assertEquals(80, assistant.knowledgeLevel())

    }

    @SpyK
    var assistant1 = Assistant("Петров", 25)

    @Test
    fun `тестируем с помощью spy`() {
        assistant1.training()
        assistant1.training()
        verify(exactly = 2) { assistant1.training() }
        assertEquals(50, assistant1.knowledgeLevel())
    }
}