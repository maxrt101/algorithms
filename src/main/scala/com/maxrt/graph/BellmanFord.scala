package com.maxrt.graph

import scala.collection.mutable.{ArrayBuffer, HashMap}
import scala.reflect.ClassTag

object BellmanFord {
  type Graph[V, T] = HashMap[V, HashMap[V, T]]
  val MaxValue = Int.MaxValue

  final case class NegativeWeightCycleException(val message: String = "", val cause: Throwable = None.orNull) extends Exception(message, cause)

  def countEdges[V: ClassTag](graph: Graph[V, Int]): Int =
    graph.foldLeft(0)((prev, next) => prev + next._2.size) / 2

  def getEdges[V: ClassTag](graph: Graph[V, Int]): Array[Tuple3[V, V, Int]] = {
    val result = ArrayBuffer.empty[Tuple3[V, V, Int]]
    for ((s, d) <- graph; (e, w) <- d) {
      result.append(Tuple3(s, e, w))
    }
    result.toArray
  }

  def search[V: ClassTag](graph: Graph[V, Int], start: V): HashMap[V, Int] = {
    val edgesCount = countEdges(graph)
    val edges = getEdges(graph)
    val result = HashMap.empty[V, Int]

    for (v <- graph.keys) {
      result.addOne(v, MaxValue)
    }

    result(start) = 0

    for (i <- 0 to edgesCount; (start, end, weight) <- edges) {
      if (result(start) != MaxValue && result(start) + weight < result(end)) {
        result(end) = result(start) + weight
      }
    }

    for ((start, end, weight) <- edges) {
      if (result(start) != MaxValue && result(start) + weight < result(end)) {
        throw new NegativeWeightCycleException(s"Negative weight cycle occured at edge ${start} -> ${end} = ${weight}")
      }
    }

    result
  }

}
