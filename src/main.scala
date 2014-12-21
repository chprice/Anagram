package project


import java.util.Properties

import edu.stanford.nlp.ling.CoreAnnotations._
import edu.stanford.nlp.ling.CoreLabel
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import edu.stanford.nlp.util.CoreMap
import models.Anatree
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps

import scala.collection.JavaConversions._

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

    val text = "The quick brown fox jumped over the lazy dog. Something about a monkey." // Add your text here!


    /*for(sentence <- document.get(classOf[SentencesAnnotation])) {

      for (token <- sentence.get(classOf[TokensAnnotation])) {
        val pos = token.get(classOf[PartOfSpeechAnnotation])
        println(pos)
      }
    }*/

  }
}