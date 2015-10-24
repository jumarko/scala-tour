package jumar.scalatour.practice

import scala.util.matching.Regex

object Extractor {

  object Email {
    def unapply(str: String): Option[(String, String)] =
      new Regex("""(.*)@(.*)""").unapplySeq(str).get match {
        case user :: domain :: Nil => Some(user, domain)
        case _ => None
      }
  }

  def main(args: Array[String]) {
    "user@example.com" match {
      case Email(user, domain) => println(s"$user @ $domain")
    }
  }
}
