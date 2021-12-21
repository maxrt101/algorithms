package com.maxrt.sort

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

object Selection {
  def sort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean): Unit = {
    for (i <- 0 until array.length) {
      var minIndex = i

      for (j <- i+1 until array.length) {
        if (comparator(array(j), array(minIndex))) {
          minIndex = j
        }
      }

      val tmp = array(i)
      array(i) = array(minIndex)
      array(minIndex) = tmp
    }
  }
}
