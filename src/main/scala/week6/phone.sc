import scala.io.Source

val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

val words = in.getLines.toList filter (word => word forall(chr => chr.isLetter))

val mnem = Map(
  '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

/** Invert the mnem map to give a map from chars 'A' ... 'Z' to '2' ... '9'*/
val charCode: Map[Char, Char] = for {(num, letters) <- mnem; char<- letters} yield  char -> num

/** Maps a word to the digit string it can represent, e.g. "Java" -> "5282" */
def wordCode(word: String): String = for (letter <- word.toUpperCase) yield charCode(letter)
wordCode("Louis")

/**
  * A map from digit strings to the words that represent them,
  * e.g. "5282" -> List("Java", "Kata", Lava", ...
  * Note: a missing number should map to the empty set, e.g. "1111" -> List()
  */
val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode