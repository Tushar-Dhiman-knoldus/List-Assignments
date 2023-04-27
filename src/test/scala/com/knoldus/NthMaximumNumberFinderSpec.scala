package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NthMaximumNumberFinderSpec extends AnyFlatSpec with Matchers {

  "findNthMaximum" should "throw an exception when the input list is empty" in {
    val nthMaxFinder = new NthMaximumNumberFinder()
    assertThrows[IllegalArgumentException] {
      nthMaxFinder.findNthMaximum(2, List.empty)
    }
  }

  it should "throw an exception when the input list has fewer elements than n" in {
    val nthMaxFinder = new NthMaximumNumberFinder()
    assertThrows[IllegalArgumentException] {
      nthMaxFinder.findNthMaximum(5, List(1, 2, 3))
    }
  }

  it should "return the nth maximum element of the input list" in {
    val nthMaxFinder = new NthMaximumNumberFinder()
    nthMaxFinder.findNthMaximum(2, List(1, 3, 5, 2, 4)) shouldEqual 4
    nthMaxFinder.findNthMaximum(1, List(1, 3, 5, 2, 4)) shouldEqual 5
    nthMaxFinder.findNthMaximum(3, List(1, 3, 5, 2, 4)) shouldEqual 3
    nthMaxFinder.findNthMaximum(3, List(1, 3, 5, 4, 4)) shouldEqual 3
  }

  it should "return the maximum element when the nth maximum is 1" in {
    val nthMaxFinder = new NthMaximumNumberFinder()
    nthMaxFinder.findNthMaximum(1, List(1, 3, 5, 2, 4)) shouldEqual 5
    nthMaxFinder.findNthMaximum(1, List(5, 4, 3, 2, 1)) shouldEqual 5
  }
}
