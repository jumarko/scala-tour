package jumar.scalatour.basics

object DuckTyping {

  def withClose(closeable: { def close() },
                 op: { def close() } => Unit): Unit = {
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
    withClose(conn, (conn) => println("Do something with Connection"))
  }

}
