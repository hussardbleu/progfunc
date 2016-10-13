val xs = Array(1, 2, 3, 44)
xs map (x => x*x)

val s = "Hello World"
s filter(c => c.isUpper)
s exists(c => c.isUpper)
s forall(c => c.isUpper)

val pairs = List(1,2,3) zip s
val otherpairs = Array(1,2,3) zip s
otherpairs.unzip
val otherpairs2 = s zip Array(1,2,3)
otherpairs2.unzip

s flatMap(c => List('.',c))
s map(c => List('.',c))

val r: Range = 1 until 5
val t: Range = 1 to 5
1 to 10 by 3
-1 to -10 by -2

def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
  //(xs zip ys).map(xy => xy._1*xy._2).sum
  (xs zip ys).map{ case (x, y) => x*y}.sum
}

def isPrime(n: Int): Boolean = (2 until n).forall(x => n % x !=0)

isPrime(9)
isPrime(1)
isPrime(2)
isPrime(4)


