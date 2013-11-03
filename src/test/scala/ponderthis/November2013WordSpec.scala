package ponderthis

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Ignore, WordSpec}
import November2013._

class November2013WordSpec extends WordSpec with ShouldMatchers with GeneratorDrivenPropertyChecks {


  def sidesWord = afterWord("the ")
  def maxDimensions = 60


  "Three hypercubes" when {
    "given dimensions d " should {
      "have matching numbers of k-dimensional elements" in {
        val cubes = hypercubes(maxDimensions).toIndexedSeq
        for (
          d1 <- 0 to maxDimensions-1;
          k1 <- 0 to maxDimensions-2;
          d2 <- 0 to maxDimensions-1;
          k2 <- 0 to maxDimensions-2;
          d3 <- 0 to maxDimensions-1;
          k3 <- 0 to maxDimensions-2
          if d1!=d2 && d2!=d3 && d1!=d3 && d1>k1 && d2>k2 && d3>k3 && cubes(d1)(k1) == cubes(d2)(k2) &&  cubes(d2)(k2) == cubes(d3)(k3)
        ) Console.err.println(s"cubes($d1)($k1) == cubes($d2)($k2) == cubes($d3)($k3) == ${cubes(d1)(k1)}")
      }
    }
  }

  /**
   *
   *
   * 10 10
   * 25 23
   * 30 55
   * [ant:scalatest] cubes(4, 1) == cubes(5, 0) == cubes(16, 15) == 32
   */

}