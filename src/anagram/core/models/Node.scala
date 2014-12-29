package anagram.core.models

import scala.collection.mutable

/**
 * Created by Random on 9/15/2014.
 */
class Node (var isWord: Boolean=false) {

  var children : mutable.Map[Char, Node] = mutable.Map.empty[Char, Node]

  def hasChildren : Boolean = {
    children.isEmpty
  }


}
