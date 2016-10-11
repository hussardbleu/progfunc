abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet

}

object Empty extends IntSet{
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def contains(x: Int): Boolean = false
  def union(other: IntSet) = other
  override def toString(): String = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet =
    if (x > elem) new NonEmpty(elem, left, right incl x)
    else if (x < elem) new NonEmpty(elem, left incl x, right)
    else this

  def contains(x: Int): Boolean =
    if (x > elem) right.contains(x)
    else if (x < elem) left.contains(x)
    else true

  def union(other: IntSet) =
    ((left union right) union other) incl elem

  override def toString(): String =
    "{" + left + elem + right + "}"
}

val t1 = new NonEmpty(3, Empty, Empty)

val t2 = t1 incl 5


abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}


