package ru.tinkoff.fintech.homework.lesson4

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.*

class MyQueueTest {
    lateinit var queue : MyQueue<Int>

    @BeforeEach
    fun setUp(){
        queue = MyQueue<Int>()
    }

    @Test
    fun `тестируем очередь на добавление и извлечение элементов`(){
        for(i in 1..100)
            queue.offer(i)
        assertEquals(100, queue.size())
        assertEquals(1, queue.element())
        assertEquals(1, queue.peek())
        for(i in 1..50){
            assertEquals(i, queue.remove())
        }
        for(i in 51..100){
            assertEquals(i, queue.poll())
        }
        assertEquals(true, queue.empty())
    }

    @Test
    fun `тестируем работу с пустой очередью`(){
        assertEquals(true, queue.empty())
        assertThrows<NoSuchElementException> {queue.remove()}
        assertThrows<NoSuchElementException> {queue.element()}
        assertNull(queue.peek())
        assertNull(queue.poll())
        for(i in 1..100)
            queue.offer(i)
        assertNotEquals(true, queue.empty())
        for(i in 1..100)
            queue.remove()
        assertEquals(true, queue.empty())
        assertThrows<NoSuchElementException> {queue.remove()}
        assertThrows<NoSuchElementException> {queue.element()}
    }

    @Test
    fun `тестирование очереди на цикличность`(){
        for(i in 1..100){
            for(j in 1..4)
                queue.offer(j)
            for(j in 1..4) {
                assertEquals(j, queue.peek())
                assertEquals(j, queue.remove())
            }
        }
        assertTrue { queue.empty() }
    }
}