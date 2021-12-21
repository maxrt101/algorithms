package com.maxrt.substr

import scala.collection.mutable.ArrayBuffer

object KMP {

  private def generateTable(substring: String): Array[Int] = {
    val result = ArrayBuffer.fill[Int](substring.length)(0)

    var i = 1
    var j = 0
    while (i < substring.length) {
      if (substring.charAt(i) == substring.charAt(j)) {
        j += 1
        result(i) = j
        i += 1
      } else {
        if (j != 0) {
          j = result(j - 1)
        } else {
          result(i) = 0
          i += 1
        }
      }
    }

    result.toArray
  }

  def search(input: String, substring: String): Array[Int] = {
    val result = ArrayBuffer.empty[Int]

    if (input.isEmpty || substring.isEmpty || input.length < substring.length) {
      return result.toArray
    }

    val partialMatch = generateTable(substring)

    var i = 0
    var j = 0
    while (i < input.length) {
      if (input.charAt(i) equals substring.charAt(j)) {
        j += 1
        i += 1
      }

      if (j == substring.length) {
        result.append(i - j)
        j = partialMatch(j - 1)
      } else if (i < input.length && ! (input.charAt(i) equals substring.charAt(j)) ) {
        if (j != 0) {
          j = partialMatch(j - 1)
        } else {
          i += 1
        }
      }
    }

    result.toArray
  }
}
