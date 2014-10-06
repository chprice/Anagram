package project

import models.Anatree
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

import cc.factorie._
import cc.factorie.app.nlp._

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {


   /* val anatree = new Anatree()

    for (line <- Source.fromURL(getClass.getResource("/words.txt")).getLines()) {
      anatree.addWord(line.stripLineEnd)
    }
    //println(anatree.count)
    val b = System.currentTimeMillis
    val anagrams = anatree.anagram("elementary")

    anagrams.map((f: Future[String]) =>
    {
      f.onSuccess {
        case s => println(s)
      }
    })

    println(System.currentTimeMillis - b + "ms")
    println(anagrams.size)
    */

    val doc = new Document("Education is the most powerful weapon which you can use to change the world.")
    DocumentAnnotatorPipeline(pos.OntonotesForwardPosTagger).process(doc)
    //pos.OntonotesForwardPosTagger.process(doc)
    for (token <- doc.tokens)
      println("%-10s %-5s".format(token.string, token.posTag.categoryValue))

  }
}