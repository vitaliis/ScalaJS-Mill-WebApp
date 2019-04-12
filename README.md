# ScalaJS-Mill-WebApp

An example of scala.js app build using Mill build tool.
To serve pages from backend cask is used.

### Useful commands

First you need to compile your ScalaJS to JS:
$ mill webApp.frontend.fastOpt

To continuously run the server and recompile it on changes:
$ mill --watch webApp.backend.runBackground
