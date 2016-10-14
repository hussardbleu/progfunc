class Poly(val terms: Map[Int, Double]) {
//  def + (other: Poly) = for {
//    s <- this
//    t <- terms
//    if s.key == t. key
//
//  }
  override def toString = {
  val poly =
    for (term <- terms)
      yield term._2.toString + " * X^" + term._1.toString
  poly mkString " + "
  }
}

val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

p1.toString()

