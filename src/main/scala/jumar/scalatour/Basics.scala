package jumar.scalatour

import java.util

object Basics {

  trait ForEachAble[A] {
    def iterator: java.util.Iterator[A]

    def foreach(f: A => Unit) = {
      val iter = iterator
      while (iter.hasNext)
        f(iter.next)
    }
  }

  trait JsonAble {
    def toJson() =
      scala.util.parsing.json.JSONFormat.defaultFormatter(this)
  }

  def main(args: Array[String]) {
    val list = new java.util.ArrayList[Int]() with ForEachAble[Int] with JsonAble
    list.add(1)
    list.add(2)

    println("For each: ");
    list.foreach(x => println(x))
    println("Json: " + list.toJson())
  }

}
