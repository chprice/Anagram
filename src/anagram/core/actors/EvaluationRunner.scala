package anagram.core.actors

import core.metrics.PopularPartOfSpeech

/**
 * Created by Random on 10/1/2014.
 */
class EvaluationRunner() {

  val popPos = new PopularPartOfSpeech()
  def score(text: String): Int = {
    popPos.score(text)
  }

}
