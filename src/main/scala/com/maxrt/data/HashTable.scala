package com.maxrt.data

import scala.collection.mutable.ArrayBuffer

// No load factor & resizing
class HashTable[K, V](val capacity: Int = 256) {

  case class Node(key: K, var value: V, var next: Node = null)

  private val buckets: ArrayBuffer[Node] = ArrayBuffer.fill(capacity)(null)

  def set(key: K, value: V): Unit = {
    val index = key.hashCode() % capacity

    if (buckets(index) == null) {
      buckets(index) = Node(key, value)
    } else {
      var node = buckets(index)
      if (node.key == key) {
        node.value = value
        return
      }
      while (node.next != null && node.next.key != key) {
        node = node.next
      }
      node.next = Node(key, value)
    }
  }

  def get(key: K): V = {
    val index = key.hashCode() % capacity

    var node = buckets(index)
    while (node.key != key && node.next != null) {
      node = node.next
    }

    if (node.key != key) throw new NoSuchElementException(s"Value for key '${key}' doesn't exist")
    node.value
  }

  def remove(key: K): Unit = {
    val index = key.hashCode() % capacity

    if (buckets(index) != null) {
      if (buckets(index).key == key) {
        buckets(index) = if (buckets(index).next == null) null else buckets(index).next
      } else {
        var node = buckets(index)
        while (node.next != null) {
          if (node.next.key == key) {
            node.next = if (node.next.next == null) null else node.next.next
          }
          node = node.next
        }
      }
    }
  }
}
