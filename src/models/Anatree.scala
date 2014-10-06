package models

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by Random on 9/15/2014.
 */
class Anatree {

  var count: Int = 0
  val root: Node = new Node()

  def addWord(word: String) = { //could sort on the way in
    var currentNode = root
    word.toCharArray.foreach((c:Char) =>
    {
      if(!currentNode.children.contains(c)){
        currentNode.children.put(c, new Node())
      }
      currentNode = currentNode.children(c)
    })
    currentNode.isWord = true
    count+=1
  }

  def checkWord(word:String): Boolean =  {
    var currentNode = root
    word.toCharArray.foreach((c:Char) =>
    {
      if(!currentNode.children.contains(c)){
        currentNode.children.put(c, new Node())
      }
      currentNode = currentNode.children(c)
    })
    currentNode.isWord
  }

  def anagram(word: String): mutable.Set[Future[String]] =
  {
    anagram_helper(root, word).map((word:Future[String]) =>{
      word.map((inverse_word: String) =>{
        inverse_word.reverse
      })
    })
  }

  private def anagram_helper(node:Node, word:String): mutable.Set[Future[String]] = {

    if(word.length == 0) return mutable.Set.empty[Future[String]]
    if (word.length == 1 && node.children.contains(word.charAt(0))
       && node.children.get(word.charAt(0)).get.isWord) {
      return mutable.Set(Future(word))
    }

    val solved_anagrams = mutable.Set.empty[mutable.Set[Future[String]]]
    if(node.isWord){
      solved_anagrams += anagram_helper(root, word).map((f:Future[String])=>{
        f.map((s:String)=>{s+" "})
      })
    }
    for(x <- 0 to word.length-1) {
      val c: Char = word.charAt(x)
      if (node.children.contains(c)) {
          val end = if (x + 1 < word.length) word.substring(x + 1) else ""
          solved_anagrams+=anagram_helper(node.children.get(c).get, word.substring(0, x) + end).map((f:Future[String])=>{
            f.map((s:String)=>{s+c})
          })
      }
    }
    solved_anagrams.flatten
  }

}
