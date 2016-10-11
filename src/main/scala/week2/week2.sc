import scala.math.abs


def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)

sum(x => x*x*x, 2, 3)


def sum2(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a+1,acc+f(a))
  }
  loop(a,0)
}

def sum3(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int ={
    if(a > b) 0
    else f(a) + sumF(a+1,b)
  }
  sumF
}

sum3(x => x)(2,3)


def sum4(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sum4(f)(a+1,b)
  }

sum4(x => x)(2,3)


def product(f: Int => Int)( a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
}

product(x => x)(1, 5)

def factorial(n: Int): Int = product(x => x)(1, n)
factorial(5)

def generalized(f: Int => Int)( a: Int, b: Int, neutral: Int, operation: (Int, Int)=> Int): Int = {
  if (a > b) neutral
  else operation(f(a) , generalized(f)(a + 1, b, neutral, operation))
}

def factorialbis(n: Int): Int = generalized(x => x)(1, n, 1, (x, y) => x * y)

factorialbis(5)




val tolerance = 0.001

def goodEnough(x: Double, y: Double): Boolean =
  (abs((x - y) / x) < tolerance)

def fixedPoint(f: Double => Double)(guess: Double): Double = {
  println("guess =" + guess)
  val a = f(guess)
  if (goodEnough(guess, a)) a
  else fixedPoint(f)(a)
}

fixedPoint(x => 1 + x/2)(4)

def sqrt(x: Double) = fixedPoint(y => (x / y + y)/2)(1.0)

sqrt(2)

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2


def sqrt2(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)
 sqrt2(2)



