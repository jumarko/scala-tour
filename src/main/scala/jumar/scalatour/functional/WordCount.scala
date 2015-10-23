package jumar.scalatour.functional


/**
 * Word count is a classic use case for Map Reduce.
 *
 * This example show two important functions: map and reduceLeft.
 * These functions can replace for-loop expression, making code cleaner!
 */
object WordCount {

  def wordcount(str: String): Int = str.split(" ").count("msg" == _)

  def main(args: Array[String]) {
    println(s"file.map: ${file.map(wordcount)}")
    println("Sums:")
    println(file.map(wordcount).reduceLeft(_ + _))
    // can be simplified to use sum function
    println(file.map(wordcount).sum)
  }
}
