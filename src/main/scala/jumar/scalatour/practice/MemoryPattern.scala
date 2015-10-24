package jumar.scalatour.practice

import scala.collection.mutable

/**
 * Memory Pattern can be used to simplify caching (improved performance).
 */
object MemoryPattern {
  val cache = new mutable.WeakHashMap[Int, Int]

  /** Wraps a function without caching to add the simple cache capability. */
  def memo(f: Int => Int) = (x: Int) => cache.getOrElseUpdate(x, f(x))

  def fibonacci_(in: Int): Int = in match {
    case 0 => 0;
    case 1 => 1;
    case n: Int => fibonacci_(n - 1) + fibonacci_(n - 2)
  }

  val fibonacci: Int => Int = memo(fibonacci_)

  def main(args: Array[String]) {

    val number = 42

    println("Without caching...")
    val start1 = System.currentTimeMillis()
    println(fibonacci(number))
    println(s"Without caching it takes: ${System.currentTimeMillis() - start1} ms")

    println("With caching...the method should return instantly!")
    val start2 = System.currentTimeMillis()
    println(fibonacci(number))
    println(s"With caching it takes: ${System.currentTimeMillis() - start2} ms")
  }
}
