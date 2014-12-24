package main.server.routes

import com.twitter.finatra.Controller
import core.actors.AnagramRunner

/**
 * Created by Random on 12/23/2014.
 */
class Api (anagramRunner: AnagramRunner) extends Controller {
  get("/data/:word.json") { request =>
    val word = request.routeParams.getOrElse("word", "foo")
    render.json(Map(word -> "bar")).toFuture
  }

  //TODO
}
