val num = List(-1, 2, 6, -3, 4, 6, 5)
val fruit = List("apple", "pineapple", "grapefruit", "banana", "shoahnanas")

num filter (x => x > 0)
num filterNot (x => x > 0)
num partition(x => x > 0)

num takeWhile(x => x > 0)
num.tail takeWhile(x => x > 0)
num dropWhile(x => x > 0)
num span(x => x > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case head :: tail => (xs takeWhile(x => x == head)) :: pack( tail dropWhile(x => x == head))

}

pack(List('a', 'a', 'a', 'b', 'b', 'c', 'c', 'a'))
