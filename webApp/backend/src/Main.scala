package app

import scalatags.Text.all._

object Main extends cask.MainRoutes {

  @cask.get("/")
  def hello() = cask.Response(
   "<!doctype html>" + "\n" + html(lang := "en",
      head(
        tag("title")("Hello from ScalaJS"),
        script(src := "/files/webApp/frontend/fastOpt/dest/out.js")
      ),
      body(
        h1("Hello :)"),
        button(onclick := "clickAction()")("click me")
      )
    ).render,
  )

  @cask.staticFiles("/files/")
  def staticFiles() = "out/" // serve files from ./out/ in the root of the project 

  @cask.staticResources("/static/") // unused, just documented as it was not very clear in docs
  def staticResources() = "." // serve files from resouces in this module

  initialize()
}
