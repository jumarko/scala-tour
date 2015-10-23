package jumar.scalatour.concurrent

import java.util.concurrent.TimeUnit

import akka.actor.ActorDSL._
import akka.actor.ActorSystem
import akka.pattern.Patterns.ask
import akka.util.Timeout

/**
 * Actors are very suitable for long running tasks like calling resource over a network.
 * This example creates a Future with "ask" function.
 */
object SynchronizedReturn {

  implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
  implicit val system = ActorSystem()

  val versionUrl = "https://raw.githubusercontent.com/scala/scala/2.11.x/build.number"

  def main(args: Array[String]) {
    val fromUrl = actor(new Act {
      become {
        case url: String => sender ! scala.io.Source.fromURL(url).getLines().mkString("\n")
      }
    })

    val version = ask(fromUrl, versionUrl, Timeout(5000, TimeUnit.MILLISECONDS))
    version.foreach(println)

    system.terminate()
  }


}
