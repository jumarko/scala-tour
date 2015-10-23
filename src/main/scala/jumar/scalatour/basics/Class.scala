package jumar.scalatour.basics

object Class {

  class Person(val firstName: String, val lastName: String) {

    private var _age = 0
    def age = _age
    def age_=(newAge: Int) = _age = newAge

    def fullName() = s"$firstName $lastName"

    override def toString: String = fullName()
  }

  def main(args: Array[String]) {
    val obama: Person = new Person("Barack", "Obama")
    println("Person: " + obama)
    println("firstName: " + obama.firstName)
    println("lastName: " + obama.lastName)
    println("age: " + obama.age)
    obama.age=51
    println("age: " + obama.age)

  }
}
