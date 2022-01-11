package io.nitesh.arrays

import scala.util.control.Breaks.break


class LongestCommonPrefixSolve {
  /**
   * function to compute longest common prefix
   *
   * @param inputArray
   */
  def solve(inputArray: Array[String]): String = {
    var res = ""
    val min = List.from(inputArray).map(i => i.length).min
    for (i <- 0 until min) {
      var c = inputArray(0).charAt(i)
      for (j <- 1 until inputArray.length) {
        if (c != inputArray(j).charAt(i)) {
          return res
        }
      }
      res += c
    }
    res
  }

  def commonPrefixUtil(a: String, b: String): String = {
    var res = ""
    if (a != null && b != null) {
      for (i <- 0 until a.length; j <- 0 until b.length) {
        if (a.charAt(i) != b.charAt(j)) {
          break
        }
        res += a.charAt(i)
      }
    }
    res
  }

  def solveUsingDivConquer(arr: Array[String], low: Int, high: Int): String = {
    if (low == high) {
      arr(low)
    }
    if (high > low) {
      val mid = low + (high - low) / 2
      val s1 = solveUsingDivConquer(arr, low, mid)
      val s2 = solveUsingDivConquer(arr, mid + 1, high)
      return commonPrefixUtil(s1, s2)
    }
    null
  }
}

object Execute {
  def main(args: Array[String]): Unit = {
    val wordArray = Array(
      "geeksforgeeks", "geeks", "geek", "geezer"
    );
    var q = new LongestCommonPrefixSolve()
    print(q.solveUsingDivConquer(wordArray, 0, wordArray.length - 1))
  }
}