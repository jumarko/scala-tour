package jumar.scalatour.concurrent

import akka.actor.{Props, ActorSystem, Actor}

/**
 * Actor is a one of scala's concurrency models.
 * It can be created via system.actorOf.
 * Use receive to get a message and ! to send a message.
 */
object UsingActor {

  implicit val system = ActorSystem()

  class EchoServer extends Actor {
    override def receive: Receive = {
      case msg: String => println("echo " + msg)
    }
  }

  def main(args: Array[String]) {
    val echoServer = system.actorOf(Props[EchoServer])
    echoServer ! "hi"

    system.terminate()
  }
}
