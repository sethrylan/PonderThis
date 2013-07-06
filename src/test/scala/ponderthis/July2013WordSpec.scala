package ponderthis

import org.scalatest.matchers.{MustMatchers, ShouldMatchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Ignore, WordSpec, FunSpec}
import ponderthis.July2013._
import ponderthis.Utils._

/**
 * see http://doc.scalatest.org/1.0/org/scalatest/WordSpec.html
 */
class July2013WordSpec extends WordSpec with ShouldMatchers with GeneratorDrivenPropertyChecks {

  "Product" should {
    "produce a set" in {
      forAll { (lists: List[List[Int]]) =>
          assert(product(lists).isInstanceOf[TraversableOnce[Any]])
      }
      forAll { (sets: Set[Set[Int]]) =>
          assert(product(sets).isInstanceOf[TraversableOnce[Any]])
      }
    }
  }

  "The product of a set" should {
    "be the product of its elements" in {
      Set(0).product should be (0)
      Set(1).product should be (1)
      Set(1,2,3).product should be (6)
      Set(3,2,1).product should be (6)
    }
  }

  "The product of set sizes" should {
    "be the product of their sizes" in {
      Set(Set(1,2,3), Set(4,5,6)).foldLeft(1)(_*_.size) should be (9)
      forAll { (lists: List[List[Int]]) =>
          lists.foldLeft(1)(_ * _.size) should be (lists.map(_.size).product)
      }
      forAll { (sets: Set[Set[Int]]) =>
          sets.foldLeft(1)(_ * _.size) should be (sets.toList.map(_.size).product)
      }
    }
  }

  "Three octahedral dice" when {
    "given sides of 8 positive integers and a total of 120 sum values " should {
      "have a minimized maximum face value" in {
//        Unfortunately, this type of code requires more time than the known universe
//        dices.map(_.max).min
//        Console.err.println(print((0 to 16387).combinations(8).find(roll(_,3).size == 120)))
      }
    }
  }

}