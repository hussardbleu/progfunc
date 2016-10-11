package week3

/**
  * Created by louisolive on 29/09/2016.
  */
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

  override def toString() = {
  val g = pgcd(numer,denom)
  numer / g + "/" + denom / g}

  def <(that: Rational) =
    numer * that.denom < denom * that.numer

  def max(that: Rational) =
    if(this.<(that)) that
    else this
}

