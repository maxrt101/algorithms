package com.maxrt.data

import scala.collection.mutable.ArrayBuffer

class PriorityQueue[T] {
  class Node[T](val data: T, val priority: Int) {
    def < (rhs: Node[T]): Boolean = {
      return priority < rhs.priority
    }

    def > (rhs: Node[T]): Boolean = {
      return priority > rhs.priority
    }
  }

  final case class EmptyQueueException(val message: String = "", val cause: Throwable = None.orNull) extends Exception(message, cause)

  private val heap = ArrayBuffer.empty[Node[T]]

  private def heapify(i: Int): Unit = {
    var largest = i
    var left = 2 * i + 1
    var right = left + 1

    if (left < heap.length && heap(left) < heap(largest)) {
      largest = left
    }

    if (right < heap.length && heap(right) < heap(largest)) {
      largest = right
    }

    if (largest != i) {
      val tmp = heap(largest)
      heap(largest) = heap(i)
      heap(i) = tmp
      heapify(largest)
    }
  }

  def length = heap.length

  def enqueue(element: T, priority: Int): Unit = {
    heap.append(Node(element, priority))
    for (i <- heap.length/2 to 0 by -1) {
      heapify(i)
    }
  }

  def dequeue(): T = {
    if (heap.isEmpty) throw new EmptyQueueException("Can't pop from empty qeueue")
    val tmp = heap(heap.length-1)
    heap(heap.length-1) = heap(0)
    heap(0) = tmp
    val node = heap.remove(heap.length-1)
    for (i <- heap.length/2 to 0 by -1) {
      heapify(i)
    }
    node.data
  }

  def peek(index: Int = 0): T = {
    if (heap.isEmpty) throw new EmptyQueueException("Can't peek on an empty qeueue")
    return heap(index).data
  }
}
