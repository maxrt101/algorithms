package com.maxrt

import scala.collection.mutable.{ArrayBuffer, HashMap}

import substr.*
import graph.*
import sort.*
import data.*

object App {
  def testBubbleSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Bubble.sort(arr, cmp)
    arr.foreach(println)
  }

  def testInsertionSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Insertion.sort(arr, cmp)
    arr.foreach(println)
  }

  def testSelectionSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Selection.sort(arr, cmp)
    arr.foreach(println)
  }

  def testMergeSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Merge.sort(arr, cmp)
    arr.foreach(println)
  }

  def testQuickSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Bubble.sort(arr, cmp)
    arr.foreach(println)
  }

  def testHeapSort(): Unit = {
    val arr = ArrayBuffer(0, 10, -4, 25, 3, 17)
    val cmp = (a: Int, b: Int) => a > b

    Heap.sort(arr, cmp)
    arr.foreach(println)
  }

  def testDijkstra(): Unit = {
    val graph = HashMap(
      'A' -> HashMap(
        'B' -> 3,
        'C' -> 1
      ),
      'B' -> HashMap(
        'A' -> 3,
        'C' -> 7,
        'D' -> 5,
        'E' -> 1
      ),
      'C' -> HashMap(
        'A' -> 1,
        'B' -> 7,
        'D' -> 2
      ),
      'D' -> HashMap(
        'B' -> 5,
        'C' -> 2,
        'E' -> 7
      ),
      'E' -> HashMap(
        'B' -> 1,
        'D' -> 7
      )
    )

    Dijkstra.getDistances(graph, 'C', 'A')
      .foreach((v: Char, d: Int) => println(s"$v -> $d"))
  }

  def testBFS(): Unit = {
    val graph = HashMap(
      'A' -> HashMap(
        'B' -> 3,
        'C' -> 1
      ),
      'B' -> HashMap(
        'A' -> 3,
        'C' -> 7,
        'D' -> 5,
        'E' -> 1
      ),
      'C' -> HashMap(
        'A' -> 1,
        'B' -> 7,
        'D' -> 2
      ),
      'D' -> HashMap(
        'B' -> 5,
        'C' -> 2,
        'E' -> 7
      ),
      'E' -> HashMap(
        'B' -> 1,
        'D' -> 7
      )
    )

    println(s"${BFS.search(graph, 'A', 'C')} ${BFS.search(graph, 'A', 'E')}")
  }

  def testDFS(): Unit = {
    val graph = HashMap(
      'A' -> HashMap(
        'B' -> 3,
        'C' -> 1
      ),
      'B' -> HashMap(
        'A' -> 3,
        'C' -> 7,
        'D' -> 5,
        'E' -> 1
      ),
      'C' -> HashMap(
        'A' -> 1,
        'B' -> 7,
        'D' -> 2
      ),
      'D' -> HashMap(
        'B' -> 5,
        'C' -> 2,
        'E' -> 7
      ),
      'E' -> HashMap(
        'B' -> 1,
        'D' -> 7
      )
    )

    println(s"${DFS.search(graph, 'A', 'C')} ${DFS.search(graph, 'A', 'E')}")
  }

  def testBellmanFord(): Unit = {
    val graph = HashMap(
      'A' -> HashMap(
        'B' -> 3,
        'C' -> 1
      ),
      'B' -> HashMap(
        'A' -> 3,
        'C' -> 7,
        'D' -> 5,
        'E' -> 1
      ),
      'C' -> HashMap(
        'A' -> 1,
        'B' -> 7,
        'D' -> 2
      ),
      'D' -> HashMap(
        'B' -> 5,
        'C' -> 2,
        'E' -> 7
      ),
      'E' -> HashMap(
        'B' -> 1,
        'D' -> 7
      )
    )

    BellmanFord.search(graph, 'A').foreach((v, d) => println(s"$v -> $d"))
  }

  def testLinkedList(): Unit = {
    val list = new LinkedList[Int]

    list.append(10)
    list.append(25)
    list.append(50)
    list.set(1, 200)
    list.append(100)
    list.remove(0)
    println(s"${list.get(0)} ${list.get(1)} ${list.get(2)}")
  }

  def testPriorityQueue(): Unit = {
    val queue = new PriorityQueue[Int]

    queue.enqueue(5, 0)
    queue.enqueue(2, 3)
    queue.enqueue(3, 2)
    queue.enqueue(1, 4)
    queue.enqueue(4, 1)

    for (_ <- 0 until 5) {
      println(s"${queue.dequeue()}")
    }
  }

  def testHashTable(): Unit = {
    val table = new HashTable[String, Int]

    table.set("abc", 40)
    table.set("test", 100)
    table.set("hash", 25)
    table.set("test", 2500)
    table.remove("abc")
    println(s"${table.get("test")}")
  }

  def testKMP(): Unit = {
    KMP.search("abxabcabcaby", "abcaby").foreach(println)
  }

  def main(args: Array[String]): Unit = {
    testKMP()
  }
}
