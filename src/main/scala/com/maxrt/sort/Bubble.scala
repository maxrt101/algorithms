package com.maxrt.sort

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.*
import scala.reflect.ClassTag

object Bubble {
  def sort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean): Unit = {
    for (i <- 0 until array.length) breakable {
      var wasSwapped = false

      for (j <- 0 until array.length - i - 1) {
        if (comparator(array(j), array(j+1))) {
          val tmp = array(j)
          array(j) = array(j+1)
          array(j+1) = tmp

          wasSwapped = true
        }
      }

      if (wasSwapped) break
    }
  }
}
