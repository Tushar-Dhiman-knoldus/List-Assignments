package com.knoldus

import org.slf4j.{Logger, LoggerFactory}

import scala.annotation.tailrec

class NthMaximumNumberFinder {

  private val logger: Logger = LoggerFactory.getLogger(getClass)

  // Function to find the nth maximum element in the list without sorting the list.
  def findNthMaximum(number: Int, listOfInteger: List[Int]): Int = {

    @tailrec
    def helper(number: Int, maxNumberList: List[Integer], listOfInteger: List[Int]): Int = {

      logger.info(s"$maxNumberList")
      if (number == 0) maxNumberList.head
      else {
        val maxNum = listOfInteger.max
        val listOfIntegerWithoutMax = listOfInteger.filter(_ != maxNum)
        helper(number - 1, maxNum :: maxNumberList, listOfIntegerWithoutMax)
      }
    }

    // if nth element is greater than size of list IllegalArgumentException is thrown
    if (number > listOfInteger.length) throw new IllegalArgumentException()
    else {
      helper(number, List.empty, listOfInteger)
    }
  }
}

