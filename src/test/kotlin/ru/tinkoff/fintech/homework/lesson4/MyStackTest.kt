package ru.tinkoff.fintech.homework.lesson4

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class MyStackTest {
    lateinit var stack :MyStack<Int>

    @BeforeEach
    fun setUp() {
        stack = MyStack()
    }

    @Test
    fun `тестируем stack на добавление и удаление элементов`(){
        for(i in 1..100) {
            stack.push(i)
        }
        assertEquals(100, stack.size())
        assertEquals(100, stack.peek())
        for(i in 100 downTo 1){
            assertEquals(i, stack.peek())
            assertEquals(i, stack.pop())
        }
        assertEquals(true, stack.empty())
    }

    @Test
    fun `тестируем пустой stack` (){
        assertTrue { stack.empty() }
        assertNull(stack.pop())
        assertNull(stack.peek())
        for(i in 1..100)
            stack.push(i)
        for(i in 1..100)
            stack.pop()
        assertTrue { stack.empty() }
        assertNull(stack.pop())
        assertNull(stack.peek())
    }
}