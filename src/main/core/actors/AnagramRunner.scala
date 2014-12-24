package core.actors

import scala.concurrent.Future
import core.models.Anatree

/**
 * Created by Random on 10/1/2014.
 */
class AnagramRunner(anatree: Anatree, evalRunner: EvaluationRunner) {

  def anagram(text: String): Set[Future[String]] = {
    anatree.anagram(text).toSet
  }

}

/*
.map((f: Future[String]) =>
    {
      f.onSuccess {
        case s => {
          println(s)
          s
        }
      }
    })
*/