package jumar.scalatour.concurrent

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * Actor is not only concurrency model, it can also be used for distributed computing.
 *
 * Note that required configuration has to be added to the application.conf!
 */
object RemoteActor {

  implicit val system = ActorSystem("RemoteSystem", ConfigFactory.load())

  class EchoServer extends Actor {
    override def receive: Receive = {
      case msg: String => println("echo " + msg)
    }
  }


  def main(args: Array[String]) {
    val server = system.actorOf(Props[EchoServer], name = "echoServer")

    val echoClient = system.actorSelection("akka.tcp://RemoteSystem@127.0.0.1:2552/user/echoServer")
    echoClient ! "Hi Remote"

    system.terminate()
  }
}
