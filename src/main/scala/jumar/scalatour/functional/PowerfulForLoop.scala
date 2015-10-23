package jumar.scalatour.functional

/**
 * For-Loop expressions in Scala can return a List.
 * Using 'yield' in the loop, the value after 'yield' will be appended to the list
 */
object PowerfulForLoop {

  def wordcount(str: String): Int = str.split(" ").count("msg" == _)

  def main(args: Array[String]) {
    // replaces map function with for loop
    val counts = for (line <- file) yield wordcount(line)
    println("wordcount: " + counts.sum)
  }

}
