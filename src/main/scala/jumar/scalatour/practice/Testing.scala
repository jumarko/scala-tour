package jumar.scalatour.practice

import org.specs2.mutable._

/**
 * Scala can use Spec2 or ScalaTest and DSL can make testing even easier.
 *
 * You need to add "specs2-core" dependency.
 */
object Testing {
  class FactorialSpec extends Specification {

    def factorial(n: Int) = (1 to n).product

    "The 'Hello world' string" should {
      "factorial 3 must be 6" in {
        factorial(3) mustEqual 6
      }
      "factorial 4 must be greater than 6" in {
        factorial(4) must greaterThan(6)
      }
    }
  }

  def main(args: Array[String]) {
    specs2.run(new FactorialSpec())
  }


}
