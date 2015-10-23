package jumar.scalatour.concurrent

object ParallelWorldCount {

  def wordcount(str: String): Int = str.split(" ").count("msg" == _)

  def main(args: Array[String]) {
    val num = file.par.map(wordcount).par.sum

    println("wordcount: " + num)
  }

}
