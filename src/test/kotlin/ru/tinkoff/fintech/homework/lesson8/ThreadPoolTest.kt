package ru.tinkoff.fintech.homework.lesson8

import org.junit.jupiter.api.Test

class ThreadPoolTest {



    @Test
    fun testThreadPool(){
        val threadPool = ThreadPool(4)
        for(i in 1..100){
            threadPool.execute {  }
        }
    }

}