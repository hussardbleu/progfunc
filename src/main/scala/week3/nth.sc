import week4._

def nth[T](n: Int, list: List[T]): T =
    if (n < 0 || list.isEmpty ) throw new IndexOutOfBoundsException ("Out of Bound")
    else if (n == 0) list.head
    else nth (n - 1, list.tail)

val y = 3

val x = new Cons[Int](3, new Cons[Int](2, new Cons[Int](1, new Nil[Int])))

nth[Int](2,x)



