def isPrime(n: Int): Boolean = (2 until n).forall(x => n % x !=0)

val n = 7
// Scala High-Order functions way
(1 until n) flatMap (i =>
  (1 until i) map(j => (i, j))) filter (pair => isPrime (pair._1 + pair._2))

// Scala For-expression way
for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
  (xs zip ys).map{ case (x, y) => x * y}.sum
}

def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double = {
  (for ((x, y) <- xs zip ys) yield x * y ).sum
}

val x1 = Vector(1.0,2.0,3.0)
val y1 = Vector(4.0,5.0,6.0)

scalarProduct(x1, y1)
scalarProduct2(x1, y1)
