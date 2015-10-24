package jumar.scalatour.basics

object CallByName {

  val logEnable = false

  // without call by name ("=>" operator) the log in main method will fail with ArithmeticException
  def log(msg : => String) = {
    if (logEnable) println(msg)
  }

  def main(args: Array[String]) {
    val msg = "programming is running"
    log(msg + 1/0)
  }
}
