/**
 *
 * http://domino.research.ibm.com/comm/wwwr_ponder.nsf/Challenges/November2013.html
 *
 * Ponder This Challenge:
 * Three dimensional cube has 8 vertices; 12 edges; and 6 faces. We may call them 0-D; 1-D; and 2-D faces respectively.
 * Denote f(d,k) as the number of k-dimensional faces of an d-dimensional hyper cube; so f(3,1)=12.
 * Find three cubes (with different dimensions d1, d2,d3) such that the number of k1, k2, k3 dimension faces are the same.
 * I.e. f(d1,k1) = f(d2,k2) = f(d3,k3).
 * We are looking for non-trivial solutions, so k1 should be less then d1.
 * Bonus: find more than three.
 *
 */

package ponderthis

object November2013 {

  /**
   * d = number of dimesions
   *
   * faces       = 2^d - 2*d = 2 = 2*faces(d-1) + edges(d-1)
   *
   * e(0,d) = vertices(d) = 2^d
   * e(1,d) = edges(d) = 2*edges(d-1) + vertices(d-1)
   * e(2,d) = faces(d) = 2*faces(d-1) + edges(d-1)    = 2^d - 2*d
   * e(k,d) = 2*e(k, d-1) + e(k-1, d-1)
   *
   */


//  val n-three:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }

//  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  /**
   * Return list of elements index by k-dimension for hypercube of d dimensions
   * @param d  dimensionality of hypercube
   * @return   List of d+1 elements, indexed by k-dimension and value equal to number of elements of k-dimension in a d-dimensional hypercube
   */
  def elements(d:Int): List[Int] =
    List.tabulate(d+1)(k => e(d, k))

  /**
   * Number of k-dimensional elements in a d-dimensional hypercube
   * @param d  dimensionality of hypercube
   * @param k  k-dimensional element (point, line, face, cell, 4-face, etc)
   * @return   number of k-dimensional elements in a d-dimensional hypercube
   */
  def e(d:Int, k:Int): Int =
    if(k > d)
      0
    else if(k == 0)
      math.pow(2,d).toInt
    else
      2*e(d-1, k) + e(d-1, k-1)


  def hypercubes(maxDimensions:Int) : Vector[Vector[Int]] =
    Vector.tabulate(maxDimensions, maxDimensions-1){ (d,k) =>
      e(d,k)
    }

}