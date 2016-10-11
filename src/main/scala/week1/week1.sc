 1 + 3
  def abs(x: Double) = if (x < 0) -x else x


  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if(isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))


    def isGoodEnough(guess: Double) =
      abs((guess * guess - x)/x) < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(3)
  sqrt(2)
  sqrt(1e-6)
  sqrt(1e60)
  sqrt(0.001)
  sqrt(1e50)


  def pgcd(a: Int,b: Int): Int =
    if(b == 0) a else pgcd(b, a % b)

  def factorial(n: Int):  Int =
    if(n == 0) 1 else n * factorial(n-1)

  def factorialTailRec(n: Int): Int = {

    def factorialAcc(n: Int,acc: Int): Int = {
      if (n == 0) acc else factorialAcc (n - 1, acc * n)
    }
    factorialAcc(n,1)
  }

  factorial(9)
  factorialTailRec(9)


