package main.server.routes

import com.twitter.finatra.Controller
import core.actors.AnagramRunner

/**
 * Created by Random on 12/23/2014.
 */
class Website(anagramRunner: AnagramRunner) extends Controller {

  get("/") { request =>
    render.static("index.html").toFuture
  }

  //TODO

}
