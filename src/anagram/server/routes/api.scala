package anagram.server.routes

import anagram.core.models.AnagramResult
import com.twitter.finatra.{ResponseBuilder, Controller}
import anagram.core.actors.AnagramRunner
import anagram.server.json.AnagramRequest

import spray.json._
import anagram.server.json.MyJsonProtocol._
import scala.concurrent.ExecutionContext.Implicits.global

import com.twitter.util.Future
import scala.concurrent.{Future, Promise}
import com.twitter.util.Await
import com.twitter.util.{Future => TwitterFuture, Promise => TwitterPromise, Throw, Return}



/**
 * Created by Random on 12/23/2014.
 */
class Api (anagramRunner: AnagramRunner) extends Controller {
  post("/api/anagram") { request =>
    println(request.contentString)
    val anagramRequest = request.contentString.parseJson.convertTo[AnagramRequest]
    val anagramResults = anagramRunner.anagram(anagramRequest.text, anagramRequest.count)
    val anagramJson = anagramResults.map((s: Set[AnagramResult])=>{
      if(!s.isEmpty) {
        s.head.toJson.compactPrint
      }
      else {
        "{}"
      }
    })

    render.plain(Await.result(anagramResults).toJson.compactPrint).toFuture
    //println(anagramJson)
    //Future[Set] => Future[Json] => render
    //val word = request.routeParams.getOrElse("word", "foo")
    //render.json(Map("data" -> anagramJson)).toFuture
    //anagramJson.map((s:String) => render.plain(s)) // do all futures as twitter futures to simplify
  }

  //TODO
}
