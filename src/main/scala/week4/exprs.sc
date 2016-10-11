package week4

object exprs{

  def show (e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
    case Var(x) => x
    case Prod(e1: Expr, e2: Expr) => show(e1) + "*" + show(e2)
  }

  show(Sum(Number(1), Number(44)))


}

