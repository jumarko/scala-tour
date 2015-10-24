package jumar.scalatour.basics

object Currying {
  def withClose[A <: { def close() }, B](closeable: A)(op: A => B): Unit = {
    try {
      op(closeable)
    } finally {
      closeable.close()
    }
  }

  class Connection {
    def close() = println("close Connection")
  }

  def main(args: Array[String]) {
    val conn = new Connection()
    withClose(conn) { conn =>
      println("do something with Connection") }
  }
}
