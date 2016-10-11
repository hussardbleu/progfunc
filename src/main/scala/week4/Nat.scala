package week4

/**
  * Created by louisolive on 30/09/2016.
  */
abstract class Nat {

  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat

}

object Zero extends Nat {
  def isZero = true
  def predecessor: Nat = throw new Error("0.predecessor")
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = if(that.isZero) that else throw new Error("negative number")

}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor: Nat = n
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat = new Succ (n + that)// also this.successor +(that.predecessor)
  def -(that: Nat): Nat = if(that isZero) this else this.predecessor -(that.predecessor)


}