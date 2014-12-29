package anagram.core.actors

import anagram.core.models.Anatree
import anagram.core.models.AnagramResult

//import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import com.twitter.util.Future
/**
 * Created by Random on 10/1/2014.
 */
class AnagramRunner(anatree: Anatree, evalRunner: EvaluationRunner) {

  def anagram(text: String, count:Int): Future[Set[AnagramResult]] = { //TODO I should come back and only get count anagrams from anatree
    val results = anatree.anagram(text)

    Future.collect(results.map((f: Future[String]) =>
    {
      f.map((s:String) => new AnagramResult(s,evalRunner.score(s)))
    }).toSeq).map((s: Seq[AnagramResult])=>{
      s.toSet
    })

  }
}
