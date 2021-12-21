package com.maxrt.sort

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

object Heap {
  private def heapify[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean, begin: Int, end: Int, i: Int): Unit = {
    var largest = i
    var left = 2 * (i-begin) + 1
    var right = left + 1

    if (left < end && comparator(array(left), array(largest))) {
      largest = left
    }

    if (right < end && comparator(array(right), array(largest))) {
      largest = right
    }

    if (largest != i) {
      val tmp = array(largest)
      array(largest) = array(i)
      array(i) = tmp
      heapify(array, comparator, begin, end, largest)
    }
  }

  private def heapSort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean, begin: Int, end: Int): Unit = {
    for (i <- (begin+end)/2 to begin by -1) {
      heapify(array, comparator, begin, end, i)
    }

    for (i <- end until begin by -1) {
      val tmp = array(begin)
      array(begin) = array(i)
      array(i) = tmp
      heapify(array, comparator, begin, i, begin)
    }
  }

  def sort[T: ClassTag](array: ArrayBuffer[T], comparator: (T, T) => Boolean): Unit = {
    heapSort(array, comparator, 0, array.length-1)
  }
}
