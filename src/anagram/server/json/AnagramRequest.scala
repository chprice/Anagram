package anagram.server.json

import anagram.core.models.AnagramResult
import spray.json.DefaultJsonProtocol
//import anagram.core.models.AnagramResult

/**
 * Created by Random on 12/24/2014.
 */
case class AnagramRequest(
                         text: String,
                         count: Int = 10

  ) {

}

/*case class AnagramResult(
                        text: String,
                        score: Int
                          )
*/
object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val anagramRequestFormat = jsonFormat2(AnagramRequest)
  implicit val anagramResultFormat = jsonFormat2(AnagramResult)
}
