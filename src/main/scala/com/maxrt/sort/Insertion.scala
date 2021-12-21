package com.maxrt.sort

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

object Insertion {
  def sort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean): Unit = {
    for (i <- 1 until array.length) {
      val key = array(i)
      var j = i - 1

      while (j >= 0 && comparator(key, array(j))) {
        array(j + 1) = array(j)
        j -= 1
      }

      array(j + 1) = key
    }
  }
}
