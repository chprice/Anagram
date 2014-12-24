package core.metrics

import java.util.Properties

import edu.stanford.nlp.ling.CoreAnnotations.{PartOfSpeechAnnotation, TokensAnnotation, SentencesAnnotation}
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import scala.collection.JavaConversions._

import main.database.POS
import main.database.postgresqlContext._

class PopularPartOfSpeech () {

  val props = new Properties()
  props.put("annotators", "tokenize, ssplit, pos") //,lemma, ner, parse, dcoref
  val pipeline = new StanfordCoreNLP(props)

  def getPosTags(text:String): List[String] ={
    val filteredText = text.filterNot(".!?-" contains _)

    val document = new Annotation(filteredText)
    pipeline.annotate(document)

    document.get(classOf[SentencesAnnotation]).flatMap( sentence => {
      sentence.get(classOf[TokensAnnotation]).map(token => {
        token.get(classOf[PartOfSpeechAnnotation])
      })
    }).toList

  }

  def score(text:String) : Int = {
    getPOSCount(getPosTags(text).mkString(" "))
  }

  def getPOSCount(posSeq: String): Int = {
    transactional {
      select[POS].where(_.sequence :== posSeq).head.count
    }
  }

  def incrementPOSCount(posSeq: String): Unit = {
    transactional {
      val seq = select[POS].where(_.sequence :== posSeq)
      if(seq.isEmpty){
        new POS(posSeq,1)
      }
      else{
        seq.head.count += 1
      }
    }
  }

}
