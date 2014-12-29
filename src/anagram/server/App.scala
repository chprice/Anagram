package anagram.server

import com.twitter.finatra.ContentType._
import com.twitter.finatra._
import anagram.core.actors.{AnagramRunner, EvaluationRunner}
import anagram.core.models.Anatree
import anagram.server.routes.{Website, Api}

object App extends FinatraServer {

  val ar = new AnagramRunner(Anatree("/words.txt"), new EvaluationRunner())

  register(new Api(ar))
  register(new Website(ar))
}
