package jumar.scalatour.concurrent

import akka.actor.{ActorSystem, Actor, Props}
import akka.testkit.CallingThreadDispatcher

/**
 * Actor is a more lightweight than thread -> millions of actors can be created.
 * The secret is that Actor can reuse a thread.
 *
 * There is no fixed mapping between Actor and Thread - An Actor can use many threads
 * and a Thread can be used by many Actors.
 */
object ActorImplementation {

  implicit val system = ActorSystem()

  class EchoServer(name: String) extends Actor {
    override def receive: Receive = {
      case msg => println(s"server $name echo $msg + by ${Thread.currentThread().getName}")
    }
  }

  def main(args: Array[String]) {
    val echoServers = (1 to 10).map(x =>
      system.actorOf(Props(new EchoServer(x.toString)).withDispatcher(CallingThreadDispatcher.Id))
    )

    (1 to 10).foreach(msg =>
      echoServers(scala.util.Random.nextInt(10)) ! msg.toString)

    system.terminate()
  }
}
