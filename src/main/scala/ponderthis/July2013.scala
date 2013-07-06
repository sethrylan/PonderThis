/**
 *
 * http://domino.research.ibm.com/Comm/wwwr_ponder.nsf/Challenges/July2013.html
 *
 * Ponder This Challenge:
 * When you roll three octahedron (eight sided) dice with the sides numbered
 * 1, 4, 16, 64, 256, 1024, 4096, 16384, there are 120 different sums which
 * can be produced. The maximal value, in this example, is 16384.
 *
 * Find the eight positive integers that could number a octahedral die and
 * minimize the maximum value of the eight faces, while still resulting in
 * 120 possible sums when three of the dice are rolled.
 */

package ponderthis

object July2013 {

  /**
   * see http://stackoverflow.com/questions/8321906/lazy-cartesian-product-of-several-seqs-in-scala
   * @param xs
   * @tparam A
   * @return
   */
  def product[A](xs: Traversable[Traversable[A]]): Seq[Seq[A]] =
    xs.foldLeft(Seq(Seq.empty[A])){
      (x, y) => for (a <- x.view; b <- y) yield a :+ b
    }

  /**
   * Returns all possible unique values of a roll of dice
   * @param sides   List of integers values for dice sides
   * @param numDice Number of independent dice to roll
   * @return        List of unique integer values from a single roll of the dice
   */
  def roll(sides: Iterable[Int], numDice: Int): Set[Int] =  {
    product(Iterable.fill(numDice)(sides)).map(_.sum) toSet
  }


//  def product[T](xss: List[List[T]]): List[List[T]] = xss match {
//    case Nil => List(Nil)
//      case h :: t => for(xh <- h; xt <- product(t)) yield xh :: xt
//  }
}
