package jumar.scalatour.practice

import java.text.SimpleDateFormat
import java.util.Date


/**
 * implicit can be used to define a conversion function - types are automatically converted when needed.
 * Implicit is the most important feature when implementing DSL.
 */
object ImplicitConversion {
  implicit def strToDate(str: String): Date = new SimpleDateFormat("yyyy-MM-dd").parse(str)

  def main(args: Array[String]) {
    println("2015-01-01 unix time: " + "2015-01-01".getTime/1000)
  }
}
