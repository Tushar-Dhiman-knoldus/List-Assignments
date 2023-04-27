package com.knoldus

import org.slf4j.{Logger, LoggerFactory}

import scala.annotation.tailrec

class ListSortChecker {

  private val logger: Logger = LoggerFactory.getLogger(getClass)

  // Function to check whether the list is sorted.
  @tailrec
  final def isSorted[T](list: List[T], compare: (T, T) => Boolean): Boolean = {
    list match {
      case Nil => true
      case _ :: Nil => true
      case head :: tail => logger.info(s"head = $head tail = $tail")
        compare(head, tail.head) && isSorted(tail, compare)
    }
  }
}
