package main.server

import com.twitter.finatra.ContentType._
import com.twitter.finatra._
import core.actors.{AnagramRunner, EvaluationRunner}
import core.models.Anatree
import main.server.routes.{Website, Api}

object App extends FinatraServer {

  val ar = new AnagramRunner(new Anatree(), new EvaluationRunner())

  register(new Api(ar))
  register(new Website(ar))
}
