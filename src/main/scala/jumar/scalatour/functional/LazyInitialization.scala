package jumar.scalatour.functional

/**
 * Field with a "lazy" keyword is only initialized when it is first accessed.
 *
 * This example is to get scala version from github (which can take some time because of network latency).
 * Lazy is very suitable for a value that takes lots of resources.
 */
object LazyInitialization {

  class ScalaStableVersion(val url: String) {
    lazy val source = {
      println(s"fetchin from url: $url")
      scala.io.Source.fromURL(url).getLines().toList
    }

    // note that you can use infix expression '_ contains blabla' instead of '_.contains("blabla")'
    lazy val majorVersion = source.find(_ contains "version.major")
    lazy val minorVersion = source.find(_ contains "version.minor")
  }

  def main(args: Array[String]) {
    val version = new ScalaStableVersion("https://raw.githubusercontent.com/scala/scala/2.11.x/build.number")

    version.majorVersion.foreach(println)
    version.minorVersion.foreach(println)
  }
}
