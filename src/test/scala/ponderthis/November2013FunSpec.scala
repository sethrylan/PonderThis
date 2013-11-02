package ponderthis

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.path.FunSpec
import ponderthis.Utils._

class November2013FunSpec extends FunSpec with ShouldMatchers with TableDrivenPropertyChecks {

  val L = List

  describe("A hypercube") {
    val elements =   Table (
      ("n", "name", "schlaefli", "elements"),
      (0,   "point", "-", L(1)),
      (1,   "line segment", "{ }", L(2,1)),
      (2,   "square/tetragon", "{4}", L(4,4,1)),
      (3,   "cube/hexahedron", "{4,3}", L(8,12,6,1)),
      (4,   "tesseract/octachoron", "{4,3,3}", L(16,32,24,8,1)),
      (5,   "penteract/decateron", "{4,3,3,3}", L(32,80,80,40,10,1)),
      (6,   "hexaract/dodecapeton", "{4,3,3,3,3}", L(64,192,240,160,60,12,1)),
      (10,   "Dekeract/icosa-10-tope", "{4,3,3,3,3,3,3,3,3}", L(1024,5120,11520,15360,13440,8064,3360,960,180,20,1))
    )

    forAll(elements) { (n:Int, name:String, schlaefli:String, elements:List[Int]) =>
      it("of " + n + " dimensions (" + name + ") will have m-dimensional elements = " + print(elements) ) {
        November2013.elements(n) should be (elements)
      }
    }
  }



}

