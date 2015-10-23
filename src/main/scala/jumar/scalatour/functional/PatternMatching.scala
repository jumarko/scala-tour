package jumar.scalatour.functional

object PatternMatching {
  def fibonacci(in: Any): Int = in match {
    case 0 => 0
    case 1 => 1
    case n: Int if n > 1 => fibonacci(n - 1) + fibonacci(n - 2)
    case n: String => fibonacci(n.toInt)
    case _ => 0
  }

  def main(args: Array[String]) {
    println(fibonacci(0))
    println(fibonacci(1))
    println(fibonacci(2))
    println(fibonacci(3))
    println(fibonacci("-3"))
    println(fibonacci("3"))
  }
}
