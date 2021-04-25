package webapp

import org.scalajs.dom

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {
  def main(args: Array[String]): Unit = println("Hello world!")

  @JSExportTopLevel("clickAction")
  def clickAction(): Unit = dom.window.alert("you just clicked me")
}
