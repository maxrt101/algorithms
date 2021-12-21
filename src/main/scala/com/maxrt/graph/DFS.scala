package com.maxrt.graph

import scala.collection.mutable.{ArrayBuffer, HashMap, Queue}
import scala.reflect.ClassTag

object DFS {
  type Graph[V, T] = HashMap[V, HashMap[V, T]]

  def search[V: ClassTag](graph: Graph[V, Int], start: V, end: V): Boolean = {
    val queue = Queue(start)
    val visited = ArrayBuffer.empty[V]

    while (queue.nonEmpty) {
      val current = queue.dequeue()
      if (graph.get(current).get.contains(end)) {
        return true
      }
      visited.append(current)
      for (v <- graph.get(current).get.keys) {
        if (!visited.contains(v)) {
          queue.enqueue(v)
        }
      }
    }

    false
  }

}
