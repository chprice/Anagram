package metrics

import java.util.Properties

import edu.stanford.nlp.ling.CoreAnnotations.{PartOfSpeechAnnotation, TokensAnnotation, SentencesAnnotation}
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import scala.collection.JavaConversions._

class PopularPartOfSpeech () {

  val props = new Properties()
  props.put("annotators", "tokenize, ssplit, pos") //,lemma, ner, parse, dcoref
  val pipeline = new StanfordCoreNLP(props)

  def getPosTags(text:String): List[String] ={
    val filteredText = text.filterNot(".!?-" contains _)

    // create an empty Annotation just with the given text
    val document = new Annotation(filteredText)

    // run all Annotators on this text
    pipeline.annotate(document)

    document.get(classOf[SentencesAnnotation]).flatMap( sentence => {
      sentence.get(classOf[TokensAnnotation]).map(token => {
        token.get(classOf[PartOfSpeechAnnotation])
      })
    }).toList

    //val annotatedText = filteredText.split("\\s+") zip posTags
  }


}
