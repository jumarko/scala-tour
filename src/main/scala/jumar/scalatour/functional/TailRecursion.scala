package jumar.scalatour.functional

/**
 * Tail Recursion is one type of Recursion, in which a function calls itself as a its last expression.
 * Tail Recursion can be optimized at compile time (no stack overflows).
 */
object TailRecursion {

  def wordcount(str: String): Int = str.split(" ").count("msg" == _)

  def foldLeft(list: List[Int])(init: Int)(f: (Int, Int) => Int): Int = {
    list match {
      case List() => init
      case head :: tail => foldLeft(tail)(f(init, head))(f)
    }
  }

  def main(args: Array[String]) {
    println("wordcount: " + foldLeft(file.map(wordcount))(0)(_ + _))
  }
}
