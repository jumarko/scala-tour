package jumar.scalatour.basics

/**
 * In Scala almost everything is a value.
 * You can define constants with "val" and variables with "var" - most of the time you will need only val-s.
 */
object ExpressionsAndValues {
  def main(args: Array[String]) {
    var helloWorld = "hello" + " world"
    println(helloWorld)

    val again = " again"
    helloWorld += again
    println(helloWorld)
  }
}
