package com.maxrt.graph

import scala.collection.mutable.HashMap
import scala.reflect.ClassTag

object Dijkstra {
  type Graph[V, T] = HashMap[V, HashMap[V, T]]
  val MaxValue = Int.MaxValue

  private def minimalDistance[V: ClassTag](dist: HashMap[V, Int], adjacent: HashMap[V, Int], visited: HashMap[V, Boolean], initialValue: V): V = {
    var minimun = MaxValue
    var vertex: V = initialValue

    for ((v, d) <- adjacent) {
      if (!visited(v) && dist(v) <= minimun) {
        minimun = dist(v)
        vertex = v
      }
    }

    vertex
  }

  def getDistances[V: ClassTag](graph: Graph[V, Int], start: V, initialValue: V): HashMap[V, Int] = {
    val dist = HashMap.empty[V, Int]
    val visited = HashMap.empty[V, Boolean]

    for (v <- graph.keys) {
      dist.addOne(v, MaxValue)
      visited.addOne(v, false)
    }

    dist(start) = 0

    for (v <- dist.keys) {
      val data = graph.get(v).get
      data(v) = 0
      val m = minimalDistance(dist, data, visited, initialValue)
      visited(m) = true
      for (v <- graph.get(m).get.keys) {
        if (!visited(v)
            && graph.get(m).get.get(v).get != 0
            && dist.get(m).get != MaxValue
            && dist.get(m).get + graph.get(m).get.get(v).get < dist.get(v).get) {
          dist(v) = dist.get(m).get + graph.get(m).get.get(v).get
        }
      }
    }

    dist
  }
}
