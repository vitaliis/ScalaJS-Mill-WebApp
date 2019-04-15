import mill._
import mill.api.Loose
import mill.define.Target
import mill.scalajslib.ScalaJSModule
import mill.scalalib._
import mill.scalalib.api.CompilationResult

//noinspection ScalaFileName
object webApp extends JavaModule {

  object frontend extends ScalaJSModule {
    override def scalaVersion = "2.12.8"
    override def scalaJSVersion = "0.6.26"

    override def ivyDeps: Target[Loose.Agg[Dep]] = super.ivyDeps() ++ Agg(
      ivy"org.scala-js::scalajs-dom::0.9.6"
    )
    // TODO: is it possible to integrate https://github.com/lihaoyi/workbench
  }

  object backend extends MyScalaModule {

    override def ivyDeps: Target[Loose.Agg[Dep]] = super.ivyDeps() ++ Agg(
      ivy"com.lihaoyi::cask:0.1.9",
      ivy"com.lihaoyi::scalatags:0.6.7",
    )

    override def compile: T[CompilationResult] = T {
      frontend.fastOpt.apply()
      super.compile.apply()
    }
  }

  object shared extends MyScalaModule {

  }

  trait MyScalaModule extends ScalaModule {
    override def scalaVersion = "2.12.8"
  }

}

