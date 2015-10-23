package jumar.scalatour.concurrent

import akka.actor.ActorDSL._
import akka.actor.ActorSystem

/**
 * Demonstrates a simpler way how to create an Actor.
 */
object SimplerActor {

  implicit val system = ActorSystem()

  def main(args: Array[String]) {
    val echoServer = actor(new Act {
      become {
        case msg => println("echo " + msg)
      }
    })

    echoServer ! "hi"
    system.terminate()
  }

}
