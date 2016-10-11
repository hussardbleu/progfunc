def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
  case List() => xs
  case head::tail => if(n==0) tail else head::removeAt(tail, n-1)

}

removeAt(List('a','b','c'),1)

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case (head: List[_])::ys => flatten(head):::flatten(ys)
  case head::tail => head :: flatten(tail)
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))

def msort(xs: List[Int]): List[Int] = {
  val n = xs.length/2
  if(n==0) xs
  else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
      case Nil =>
        ys
      case x::xtail => ys match {
        case Nil =>
          xs
        case y::ytail =>
          if (x < y) x :: merge(xtail, ys)
          else y :: merge(xs,ytail)
      }
    }
    val (left, right) = xs splitAt n
    merge(msort(left), msort(right))
  }

}


def mergeSort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  val n = xs.length/2
  if(n==0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs,ys) match {
      case (Nil,_) =>
        ys
      case (_,Nil) =>
        xs
      case (x::xtail,y::ytail) =>
          if (less(x,y)) x :: merge(xtail, ys)
          else y :: merge(xs,ytail)
      }
    val (left, right) = xs splitAt n
    merge(mergeSort(less)(left), mergeSort(less)(right))
  }

}

def basicMergeSort[T <% Ordered[T]](list: List[T]) = mergeSort((x: T, y: T) => x < y)(list)


basicMergeSort(List('L','o','u','i','s'))
