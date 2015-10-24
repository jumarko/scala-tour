package jumar.scalatour.practice

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods.{pretty,render}
import java.util.Date

/**
 * DSL is the most powerful tool in Scala.
 *
 * This example generates Json with a DSL - you will need the http://json4s.org/ dependency.
 */
object DSL {
  case class Twitter(id: Long, text: String, publishedAt: Option[Date])

  val twitters = Twitter(1, "hello scala", Some(new Date())) :: Twitter(2, "I like scala tour", None) :: Nil

  val json = ("twitters"
    -> twitters.map(
      t => ("id" -> t.id) ~ ("text" -> t.text) ~ ("published_at" -> t.publishedAt.toString)))

  def main(args: Array[String]) {
    println(pretty(render(json)))
  }
}
