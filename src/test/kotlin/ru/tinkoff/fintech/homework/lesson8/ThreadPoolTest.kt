package ru.tinkoff.fintech.homework.lesson8
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class ThreadPoolTest {
    @Volatile
    private var x:AtomicInteger = AtomicInteger(0)

    @Test
    fun testThreadPool() {
        val n = 100011
        for (j in 1..200) {
            x.set(0)
            val threadPool = ThreadPool(4)
            for (i in 1..n) {
                threadPool.execute(this::f)
            }
            threadPool.shutdown()
            assertEquals(n, x.toInt())
        }
    }

    private fun f():Unit{
        x.incrementAndGet()
    }
}
