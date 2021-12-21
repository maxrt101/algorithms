package com.maxrt.data

class LinkedList[T] {
  case class Node[T](var data: T, var next: Node[T] = null)

  private var root: Node[T] = null
  private var size: Int = 0

  def insert(element: T, index: Int): Unit = {
    if (index == 0) {
      if (root == null) {
        root = Node(element)
      } else {
        root = Node(element, root)
      }
    } else {
      var node = root
      for (i <- 0 until index-1) {
        node = node.next
      }
      node.next = Node(element, node.next)
    }
    size += 1
  }

  def append(element: T): Unit = {
    insert(element, size)
  }

  def get(index: Int): T = {
    var node = root
    for (i <- 0 until index) {
      node = node.next
    }
    node.data
  }

  def set(index: Int, element: T): Unit = {
    var node = root
    for (i <- 0 until index) {
      node = node.next
    }
    node.data = element
  }

  def remove(index: Int): Unit = {
    if (index == 0) {
      root = if (root.next != null) root.next else null
    } else {
      var prevNode = root
      for (i <- 0 until index - 1) {
        prevNode = prevNode.next
      }
      if (prevNode.next != null) {
        prevNode.next = if (prevNode.next.next != null) prevNode.next.next else null
      } else {
        throw new NoSuchElementException("Element can't be removed, because it doesn't exist")
      }
    }
    size -= 1
  }
}
