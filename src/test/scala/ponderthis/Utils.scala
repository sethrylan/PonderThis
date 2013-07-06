package ponderthis

object Utils {
  def print(i : Traversable[TraversableOnce[Any]]): String =  print(i.map(print(_)))
  def print(i : TraversableOnce[Any]): String = i.mkString("[", ",", "]")

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("elapsed:\t" + (t1 - t0)/1000/1000 + "ms")
    result
  }

}
