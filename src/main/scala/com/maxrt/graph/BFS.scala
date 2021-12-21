package com.maxrt.graph

import scala.collection.mutable.{ArrayBuffer, HashMap, Stack}
import scala.reflect.ClassTag

object BFS {
  type Graph[V, T] = HashMap[V, HashMap[V, T]]

  def search[V: ClassTag](graph: Graph[V, Int], start: V, end: V): Boolean = {
    val stack = Stack(start)
    val visited = ArrayBuffer.empty[V]

    while (stack.nonEmpty) {
      val current = stack.pop()
      if (graph.get(current).get.contains(end)) {
        return true
      }
      visited.append(current)
      for (v <- graph.get(current).get.keys) {
        if (!visited.contains(v)) {
          stack.push(v)
        }
      }
    }

    false
  }
}
