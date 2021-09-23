package ru.sber.generics
import java.util.*
import kotlin.collections.ArrayList

// 1.
fun <K,V> compare(p1: Pair<K, V>, p2: Pair<K,V>): Boolean {
    return p1.first==p2.first  && p1.second == p2.second
}

// 2.
fun <T:Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    return anArray.filter{ it > elem }.count()
}

// 3.
class Sorter<T:Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
   }
}

// 4.
class Stack<T> {

    val list: ArrayList<T> = arrayListOf<T>()
    var top: Int = -1

    fun push(el: T) {
        list.add(el)
        top+=1
    }
    fun pop(): T {
        val el = list.get(list.size - 1)
        list.remove(el)
        top-=1
        return el
    }
    fun isEmpty(): Boolean {
        return top == -1
    }


}