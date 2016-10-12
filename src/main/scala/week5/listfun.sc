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

def encode[T](xs: List[T]): List[(T, Int)] = {

  def encodePackedList [U](ys: List[List[U]], acc: List[(U, Int)]): List[(U, Int)] = ys match {
    case Nil => acc
    case (y: List[U]) :: (ys1: List[List[U]])  => encodePackedList(ys1,(y.head,y.length)::acc)
  }
  encodePackedList(pack(xs), Nil)
}

encode(List('a', 'a', 'a', 'b', 'b', 'c', 'c', 'a'))

def concat[T](xs: List[T], ys: List[T]): List[T] = {
  (xs foldRight ys) (_ :: _)
}

concat(List(1,2,3),List(4,5,6))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_) :: _ )

mapFun(List(1,2,3), (x: Int) => (x+1))

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (x, y) => 1 + y )

lengthFun(List(1,2,3,4))
