package ponderthis

import org.scalatest.matchers.{MustMatchers, ShouldMatchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Ignore, WordSpec, FunSpec}
import ponderthis.July2013.product
import ponderthis.July2013.roll
import org.scalatest.prop.Tables.Table


class July2013Spec extends WordSpec with ShouldMatchers with GeneratorDrivenPropertyChecks {

  "Product" should {
    "produce a sequence with a size equal to the product of all arguments" ignore {
      forAll {
        (lists: List[List[Int]]) =>
          whenever((1 to 10000000).contains(lists.foldLeft(1)(_*_.size)) ) {
            (lists.foldLeft(1)(_*_.size)) should be (product(lists).size)
          }
      }
    }
  }

  "The product of a set" should {
    "be the product of its elements" in {
      Set(1,2,3).product should be (6)
    }
  }

  "The product of two set sizes" should {
    "be the product their sizes" in {
      Set(Set(1,2,3), Set(4,5,6)).foldLeft(1)(_*_.size) should be (9)
    }
  }

}