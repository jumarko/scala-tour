package jumar.scalatour.functional

/**
 * Compares imperative approach to the powerful FP approach.
 * "Ruby's power is from magic, but Scala's power is from science".
 */
object FunctionPower {
  def containsOdd(list: List[Int]): Boolean = {
    for (i <- list) {
      if (i % 2 == 1) return true
    }

    false
  }

  def main(args: Array[String]) {
    println("List contains Odd ? " + containsOdd(List(1,2,3,4)))
    println("List contains Odd ? " + List(1,2,3,4).exists(_ % 2 == 1))

    println("List contains Odd ? " + containsOdd(List(2,4,6,8)))
    println("List contains Odd ? " + List(2,4,6,8).exists(_ % 2 == 1))
  }
}
