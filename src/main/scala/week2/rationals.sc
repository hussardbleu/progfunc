class Rational (x: Int, y: Int){
  require(y != 0, "denominator must be nonzero")
  require(y > 0, "denominator must be positive")
  private def pgcd(a: Int,b: Int): Int =
    if(b == 0) a else pgcd(b, a % b)


  def numer = x
  def denom = y

  def this(x: Int) = this(x,1)

  def +(that: Rational) =
    new Rational (numer * that.denom + denom * that.numer, denom * that.denom)

  def unary_- =
    new Rational(-numer,denom)

  def -(that: Rational) =
    this.+(-that)

  override def toString() =
    val g = pgcd(numer,denom)
    numer / g + "/" + denom / g

  def <(that: Rational) =
    numer * that.denom < denom * that.numer

  def max(that: Rational) =
    if(this.<(that)) that
    else this
}

def addRational(a: Rational, b: Rational): Rational =
  new Rational(a.numer * b.denom + a.denom * b.numer, a.denom * b.denom)

def makeString(a: Rational) =
  a.numer + "/" + a.denom
val x = new Rational(1,3)
x.numer
val p = -x

val y = new Rational(5,7)

val z = new Rational(3,2)

makeString(addRational(x,y))

val t = x.+(y)
z.toString()

z.unary_-()
-z

x - y
x- y- z

y + y
x < y
x max y
(x + y).toString()
x - y
-x



