package com.maxrt.sort

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

object Quick {
  private def partition[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean, begin: Int, end: Int): Int = {
    var prev = begin

    for (i <- begin to end) {
      if (comparator(array(i), array(end))) {
        if (array(prev) != array(i)) {
          val tmp = array(prev)
          array(prev) = array(i)
          array(i) = tmp
        }
        prev += 1
      }
    }

    if (array(prev) != array(end)) {
      val tmp = array(prev)
      array(prev) = array(end)
      array(end) = tmp
    }

    prev
  }

  private def quickSort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean, begin: Int, end: Int): Unit = {
    if (begin < end) {
      val partitionPoint = partition(array, comparator, begin, end)
      quickSort(array, comparator, begin, partitionPoint-1)
      quickSort(array, comparator, partitionPoint, end)
    }
  }

  def sort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean): Unit = {
    quickSort(array, comparator, 0, array.length-1)
  }
}
