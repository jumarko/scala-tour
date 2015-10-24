package jumar.scalatour.basics

/**
 * Functions can be created with "def", assigned to val or var and passed as an argument to another functions.
 */
object FirstClassFunctions {
  def square(a: Int) = a * a

  def squareWithBlock(a: Int) = {
    a * a
  }

  // function created with an anonymous function literal
  val squareVal = (a: Int) => a * a

  def addOne(f: Int => Int, arg: Int) = f(arg) + 1

  def main(args: Array[String]) {
    println("square(2): " + square(2))
    println("squareWithBlock(2): " + squareWithBlock(2))
    println("squareVal(2): " + squareVal(2))
    println("addOne(squareVal, 2): " + addOne(squareVal, 2))
  }
}
