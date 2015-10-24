package jumar.scalatour.practice

import org.apache.commons.beanutils.BeanUtils

import scala.beans.BeanProperty

/**
 * Scala can execute java code very easily.
 * Java can also use Scala.
 *
 * Note that this example requires commons-beanutils dependency.
 */
object UsingJava {
  // @BeanProperty add java style getter and setter thus beanutils can work properly
  class SimpleBean(@BeanProperty var name: String) {}

  def main(args: Array[String]) {
    val bean = new SimpleBean("foo")
    println(BeanUtils.describe(bean))
  }
}
