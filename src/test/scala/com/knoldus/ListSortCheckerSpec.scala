package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class ListSortCheckerSpec extends AnyFlatSpec {

  "The isSorted method" should "return true for an empty list" in {
    val checker = new ListSortChecker()
    val list = List.empty[Int]
    assert(checker.isSorted(list, (element1: Int, element2: Int) => element1 <= element2))
  }

  it should "return true for a list with one element" in {
    val checker = new ListSortChecker()
    val list = List(1)
    assert(checker.isSorted(list, (element1: Int, element2: Int) => element1 <= element2))
  }

  it should "return true for a sorted list of integers" in {
    val checker = new ListSortChecker()
    val list = List(1, 2, 3, 4, 5)
    assert(checker.isSorted(list, (element1: Int, element2: Int) => element1 <= element2))
  }

  it should "return false for an unsorted list of integers" in {
    val checker = new ListSortChecker()
    val list = List(5, 4, 3, 2, 1)
    assert(!checker.isSorted(list, (element1: Int, element2: Int) => element1 <= element2))
  }

  it should "return true for a sorted list of strings" in {
    val checker = new ListSortChecker()
    val list = List("apple", "banana", "cherry")
    assert(checker.isSorted(list, (element1: String, element2: String) => element1 <= element2))
  }

  it should "return true for a sorted list of Characters" in {
    val checker = new ListSortChecker()
    val list = List('a', 'b', 'c', 'd', 'e')
    assert(checker.isSorted(list, (element1: Char, element2: Char) => element1 <= element2))
  }
}
