package anagram.util

import anagram.database.POS

import scala.io.Source
import anagram.database.postgresqlContext._

/**
 * Created by Random on 12/29/2014.
 */
class POSimporter() {

  def importFromFile(fileName:String) = {
    for(line <- Source.fromFile(fileName).getLines()){
      transactional {
        new POS(line, 1) //check if this has newlines
      }
    }
  }
}
