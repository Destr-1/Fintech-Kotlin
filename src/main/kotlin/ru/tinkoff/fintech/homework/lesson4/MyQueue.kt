package ru.tinkoff.fintech.homework.lesson4

class MyQueue<T> {
    private val INIT_SIZE = 16
    private val TRESHOLD = 0.75
    private var queue = arrayOfNulls<Any>(INIT_SIZE) as Array<T>
    private var head = 0
    private var tail = 0


    fun size(): Int {
        if (head <= tail)
            return tail - head
        return queue.size - (tail - head)
    }

    fun empty() = tail == head

    private fun resize(newLength: Int) {
        val n = this.size()
        val newQueue = arrayOfNulls<Any>(newLength) as Array<T>
        if (head <= tail)
            System.arraycopy(queue, head, newQueue, 0, tail - head)
        else {
            System.arraycopy(queue, head, newQueue, 0, queue.size - head)
            System.arraycopy(queue, 0, newQueue, queue.size - head, tail)
        }
        tail = n
        head = 0
        queue = newQueue
    }

    fun offer(e: T): Boolean {
//        if(!(e is T))
//            return false
        if (this.size() >= queue.size * TRESHOLD) {
            this.resize(queue.size * 2)
        }
        queue[tail] = e
        tail = (tail + 1) % queue.size
        return true
    }

    fun element(): T {
        if (this.empty())
            throw NoSuchElementException("queue is empty")
        else
            return queue[head]
    }

    fun peek(): T? {
        return if (this.empty())
            null
        else
            queue[head]
    }

    fun remove(): T{
        if(this.empty())
            throw NoSuchElementException("queue is empty")
        else{
            val e = queue[head]
            head = (head+1) % queue.size
            return e
        }
    }

    fun poll(): T?{
        return if(this.empty())
            null
        else{
            val e = queue[head]
            head = (head+1) % queue.size
            e
        }
    }

}