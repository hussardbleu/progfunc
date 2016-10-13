package week6
object pairs {
val n = 7
  (1 until n) flatMap (i =>
    (1 until i) map(j => (i, j)))

}

