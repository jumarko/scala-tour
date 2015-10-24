package jumar.scalatour.practice

/**
 * In scala the == is the same as equals.
 */
object Equality {

  case class Person(val name: String) {
    // if you use "case class" you don't need to override equals function
//    override def equals(other: Any): Boolean = other match {
//      case that: Person => name.equals(that.name)
//      case _ => false
//    }
  }

  def main(args: Array[String]) {
    println(new Person("Black") == new Person("Black"))
  }
}
