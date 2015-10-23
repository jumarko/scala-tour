package jumar.scalatour.basics

import java.util.Scanner

// not that we need to add scala-reflect dependency (build.sbt)
import scala.reflect.io.File

object LoanPattern {

  def withScanner(file: File, op: Scanner => Unit): Unit = {
    val scanner = new Scanner(file.bufferedReader)
    try {
      op(scanner)
    } finally {
      scanner.close()
    }
  }



  def main(args: Array[String]) {
    // following works only on linux
    withScanner(File("/proc/self/pid"),
        scanner => println(s"pid is ${scanner.next}"))
  }
}
