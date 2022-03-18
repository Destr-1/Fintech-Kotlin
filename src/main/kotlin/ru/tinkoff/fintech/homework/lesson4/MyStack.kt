package ru.tinkoff.fintech.homework.lesson4

class MyStack<T> {
    private val INIT_SIZE = 16
    private var stackPointer = 0
    private var stack = arrayOfNulls<Any>(INIT_SIZE) as Array<T>

    fun push(element : T){
        if(stackPointer >= stack.size) {
            resize(stack.size * 2)
        }
        stack[stackPointer++] = element
    }
    fun size() = stackPointer
    fun pop() = if(this.empty()) null else stack[--stackPointer]

    fun peek() = if(this.empty()) null else stack[stackPointer-1]

    fun empty() = stackPointer == 0

    private fun resize(newLength : Int){
        val newStack = arrayOfNulls<Any>(newLength) as Array<T>
        System.arraycopy(stack, 0, newStack, 0, stackPointer)
        stack = newStack
    }
}