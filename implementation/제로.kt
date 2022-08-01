import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

fun main(args: Array<String>) {
    print(solution2(br.readLine().toInt()))
}

fun solution1(count: Int): Int {
    val numbers = mutableListOf<Int>()
    repeat(count) {
        val num = br.readLine().toInt()
        if (num == 0 && numbers.isNotEmpty()) numbers.removeLast()
        else numbers.add(num)
    }

    return numbers.sum()
}

fun solution2(count: Int): Int {
    val stack = Stack<Int>()
    repeat(count) {
        val num = br.readLine().toInt()
        if (num == 0) stack.pop()
        else stack.push(num)
    }

    return stack.stack.sum()
}

class Stack<T>() {
    private val _stack = arrayListOf<T>()
    val stack: List<T> get() = _stack

    fun isEmpty() = _stack.size == 0

    fun push(element: T) {
        _stack.add(element)
    }

    fun pop(): T? {
        if (isEmpty()) return null
        return _stack.removeAt(_stack.size - 1)
    }

    fun peek(): T? {
        if (isEmpty()) return null
        return _stack[_stack.size - 1]
    }

    fun getCount() = _stack.size
}