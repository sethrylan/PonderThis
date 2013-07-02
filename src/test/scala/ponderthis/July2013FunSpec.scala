package ponderthis

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.path.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import ponderthis.July2013.roll
import ponderthis.July2013.product



/*
http://alvinalexander.com/scala/how-create-scala-list-range-fill-tabulate-constructors
http://www.scalatest.org/getting_started_with_fun_spec
http://rosettacode.org/wiki/Combinations_with_repetitions#Scala
http://docs.scala-lang.org/style/declarations.html
http://docs.scala-lang.org/overviews/core/futures.html
http://mkaz.com/solog/scala/10-scala-one-liners-to-impress-your-friends.html
http://domino.research.ibm.com/Comm/wwwr_ponder.nsf/Challenges/July2013.html

http://www.scalatest.org/user_guide/matchers_quick_reference
*/

class July2013FunSpec extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  describe("Product") {
    val productValues =   Table (
      ("lists", "result"),
      // a flat list
      (List(List( 1, 4, 16, 64, 256, 1024, 4096, 16384)), List( 1, 4, 16, 64, 256, 1024, 4096, 16384).map(List(_))),
      // 2x2
      (List(List(1,2), List(3,4)), List(List(1,3), List(1,4), List(2,3), List(2,4))),
      // 3x2
      (List(List("a","b","c"), List(1,2)),
        (List(List("a", 1), List("a", 2),
              List("b", 1), List("b", 2),
              List("c", 1), List("c", 2)))),
      // 3x2x2
      (List(List("a","b","c"), List(1,2), List("S","T")),
        (List(List("a", 1, "S"), List("a", 1, "T"), List("a", 2, "S"), List("a", 2, "T"),
              List("b", 1, "S"), List("b", 1, "T"), List("b", 2, "S"), List("b", 2, "T"),
              List("c", 1, "S"), List("c", 1, "T"), List("c", 2, "S"), List("c", 2, "T"))))
    )

    forAll(productValues) { (lists: List[List[Any]], result: List[List[Any]]) =>
      it("with arguments of " + lists + " should produce " + result) {
        product(lists).toList should be (result)
      }
    }
  }

  describe("Three dice") {
    val diceValues =
      Table (
        ("sides", "numDice", "numValues"),
        (List( 1, 4, 16, 64, 256, 1024, 4096, 16384), 3, 120)
      )

    forAll(diceValues) { (sides: List[Int], numDice: Int, numValues: Int) =>
      it("with sides of " + sides + " should have " + numValues + " possible sum values") {
        roll(sides, numDice).size should be (numValues)
      }
    }
  }

}

