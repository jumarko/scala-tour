package jumar.scalatour.concurrent

/**
 * Accessing several URLs in parallel can be faster.
 */
object ParallelCollection {
  def main(args: Array[String]) {
    val urls = List("http://scala-lang.org", "https://github.com/yankay/scala-tour",
                    "http://example.com", "http://example.org")

    def fromURL(url: String) = scala.io.Source.fromURL(url).getLines().mkString("\n")

    val start = System.currentTimeMillis()
    // It's exciting to combine functional and parallel programming
    urls.par.map(fromURL)
    println(s"time: ${System.currentTimeMillis() - start} ms")
  }
}
