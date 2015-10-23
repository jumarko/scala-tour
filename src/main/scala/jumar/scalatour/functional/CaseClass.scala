package jumar.scalatour.functional

/**
 * Case classes are used to conveniently store and match on the contents of the class.
 * You can constract them without using new.
 * They have hashcode, equals and nice toString methods.
 */
object CaseClass {
  abstract class Expr

  case class FibonacciExpr(n: Int) extends Expr {
    require(n >= 0, "number must not be negative")
  }

  case class SumExpr(a: Expr, b: Expr) extends Expr

  def value(in: Expr): Int = in match {
    case FibonacciExpr(0) => 0
    case FibonacciExpr(1) => 1
    case FibonacciExpr(n) =>
      value(SumExpr(FibonacciExpr(n - 1), FibonacciExpr(n - 2)))
    case SumExpr(a, b) => value(a) + value(b)
    case _ => 0
  }

  def main(args: Array[String]) {
    println(value(FibonacciExpr(3)))
    println(value(FibonacciExpr(-1)))
  }
}
