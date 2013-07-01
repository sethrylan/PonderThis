package ponderthis

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.path.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.prop.GeneratorDrivenPropertyChecks

/*
http://alvinalexander.com/scala/how-create-scala-list-range-fill-tabulate-constructors
http://www.scalatest.org/getting_started_with_fun_spec
http://rosettacode.org/wiki/Combinations_with_repetitions#Scala
http://docs.scala-lang.org/style/declarations.html
http://docs.scala-lang.org/overviews/core/futures.html
http://mkaz.com/solog/scala/10-scala-one-liners-to-impress-your-friends.html
http://domino.research.ibm.com/Comm/wwwr_ponder.nsf/Challenges/July2013.html
*/

class July2013Spec extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

//
//  describe("Three identical octahedrons with values " + sides.toString()) {
//    it("should have 120 possible values") {
//      assert(Dice.roll(sides, 3).size == 120)
//    }
//  }

  describe("Three dice") {
    val diceValues =
      Table (
        ("sides", "numDice", "numValues"),
        (List( 1, 4, 16, 64, 256, 1024, 4096, 16384), 3, 120)
      )

    forAll(diceValues) { (sides: List[Int], numDice: Int, numValues: Int) =>
      it("with sides of " + sides.toString + " should have " + numValues + " possible sum values") {
        Dice.roll(sides, numDice).size should be (numValues)
      }
    }

  }


}