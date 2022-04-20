package ru.tinkoff.fintech.homework.lesson8

import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(size: Int) : java.util.concurrent.Executor {
    private val threadList: MutableList<Thread> = mutableListOf()
    private val taskQueue: LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()
    private var isShutDown = false

    init {
        if (size <= 0)
            throw ExceptionInInitializerError("ThreadPool size must be > 0")
        for (i in 1..size) {
            val worker = WorkerThread()
            worker.start()
            threadList.add(worker)
        }
    }

    override fun execute(command: Runnable) {
        synchronized(taskQueue) {
            taskQueue.put(command)
            (taskQueue as Object).notify()
        }
    }

    fun shutdown() {
        isShutDown = true
        for (thread in threadList) {
            thread.interrupt()
        }
        for (thread in threadList) {
            thread.join()
        }
    }

    inner class WorkerThread() : java.lang.Thread() {
        override fun run() {
            super.run()
            while (true) {
                var task: Runnable? = null
                try {
                    synchronized(taskQueue) {
                        if (taskQueue.isEmpty()) {
                            if (!isShutDown) {
                                (taskQueue as Object).wait()
                            }
                        } else {
                            task = taskQueue.poll()
                        }
                    }
                } catch (e: InterruptedException) {
                }
                if (task != null) {
                    task!!.run()
                }
                if (taskQueue.isEmpty() && isShutDown) {
                    break
                }
            }
        }
    }
}
