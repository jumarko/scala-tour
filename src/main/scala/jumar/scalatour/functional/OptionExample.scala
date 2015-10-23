package jumar.scalatour.functional

/**
 * Scala provides an Option feature to avoid checking null everywhere.
 *
 * Pattern matching is a common way to get the value of the Option.
 * Use getOrElse to provide default value when Option is None.
 */
object OptionExample {

  def getProperty(name: String): Option[String] = {
    val value = System.getProperty(name)
    if (value == null) Some(value) else None
    // above statement can also be expressed as
     Option(value)
  }

  def main (args: Array[String]){
    val osName = getProperty("os.name")
    // following property doesn't exist
//     val osName = getProperty("os.nameX")

    osName match {
      case Some(value) => println(value)
      case _ => println("none")
    }

    println(osName.getOrElse("none"))

    osName.foreach(print)
  }
}
