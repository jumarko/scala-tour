package jumar.scalatour.functional

/**
 * Besides simplifying code, functional approach is more concerned with Input & Output without side-effects.
 *
 * This code simulates following unix command: cat file | grep 'warn' | grep '2013' | wc
 */
object FunctionTruePower {

  def main(args: Array[String]) {
    println("cat file | grep 'warn' | grep '2013' | wc : "
        + file
      .filter(_.contains("warn"))
      // .filter and .size can be replaced with single .count
      .filter(_.contains("2013"))
      .size)
  }

}
