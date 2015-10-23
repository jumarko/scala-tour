package jumar.scalatour.basics

object Generic {

  def withClose[A <: { def close(): Unit }, B](closeable: A)(f: A => B): B = {
    try {
      f(closeable)
    } finally {
      closeable.close()
    }
  }

  class Connection {
    def close() = println("Close connection")
  }

  def main(args: Array[String]) {
    val conn = new Connection()
    val msg = withClose(conn) { conn =>
      println("do something with connection")
      123456
    }
    println(msg)
  }
}
