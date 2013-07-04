package ponderthis

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.TableDrivenPropertyChecks
import ponderthis.July2013.roll
import ponderthis.July2013.product
import org.scalatest.path.FunSpec


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

  def print(i : Traversable[TraversableOnce[Any]]): String =  print(i.map(print(_)))
  def print(i : TraversableOnce[Any]): String = i.mkString("[", ",", "]")
  val L = List

  describe("Product") {
    val productValues =   Table (
      ("input", "output"),
      // 0
      (L(L.empty), L.empty),
      // 0x0
      (L(L.empty, L.empty), L.empty),
      // 1x0, 0x1
      (L(L(1), L.empty), L.empty),
      (L(L.empty, L(1)), L.empty),
      // 1x1
      (L(L(1)), L(L(1))),
      // 8x1
      (L(L( 1, 4, 16, 64, 256, 1024, 4096, 16384)), L( 1, 4, 16, 64, 256, 1024, 4096, 16384).map(L(_))),
      // 2x2
      (L(L(1,2), L(3,4)), L(L(1,3), L(1,4), L(2,3), L(2,4))),
      // 3x2
      (L(L("a","b","c"), L(1,2)),
        L(L("a", 1), L("a", 2),
          L("b", 1), L("b", 2),
          L("c", 1), L("c", 2))),
      // 3x2x2
      (L(L("a","b","c"), L(1,2), L("S","T")),
        L(L("a", 1, "S"), L("a", 1, "T"), L("a", 2, "S"), L("a", 2, "T"),
          L("b", 1, "S"), L("b", 1, "T"), L("b", 2, "S"), L("b", 2, "T"),
          L("c", 1, "S"), L("c", 1, "T"), L("c", 2, "S"), L("c", 2, "T")))
    )

    forAll(productValues) { (input: List[List[Any]], output: List[List[Any]]) =>
      it("with arguments of " + print(input) + " should produce " + print(output)) {
        product(input).toList should be (output)
      }
    }
  }


  describe("N dice") {
    val rollValues =   Table (
      ("sides", "numDice", "numValues", "maxValue"),
      (L(1), 1, 1, 1),
      (L(1), 3, 1, 3),
      (L(1,1), 1, 1, 1),
      (L(1,2), 1, 2, 2),
      (L(1,2), 2, 3, 4),
      (L(1, 4, 16, 64, 256, 1024, 4096, 16384), 3, 120, 16384)
    )

    forAll(rollValues) { (sides: List[Int], numDice: Int, numValues: Int, maxValue:Int) =>
      it("with N=" + numDice + " and sides of " + print(sides) + " should have " + numValues + " possible roll values") {
        roll(sides, numDice).size should be (numValues)
      }
      it("with N=" + numDice + " and sides of " + print(sides) + " should have a max value of " + maxValue) {
        roll(sides, numDice).max should be (maxValue)
      }
    }
  }

}

