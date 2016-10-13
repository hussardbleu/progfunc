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



