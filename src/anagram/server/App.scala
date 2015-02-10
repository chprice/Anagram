package anagram.server

import java.io.File

import com.twitter.finatra.ContentType._
import com.twitter.finatra._
import anagram.core.actors.{AnagramRunner, EvaluationRunner}
import anagram.core.models.Anatree
import anagram.server.routes.{Website, Api}

import anagram.util.POSimporter
import com.typesafe.config.{Config, ConfigFactory}

import scalikejdbc._

object App extends FinatraServer {

  val conf = ConfigFactory.parseFile(new File("./application.json"))

  System.setProperty("com.twitter.finatra.config.adminPort", if(conf.hasPath("port")) conf.getString("port") else ":9991")

  if(conf.hasPath("POSImportFileName")){
    new POSimporter().importFromFile(conf.getString("POSImportFileName"))
  }

  Class.forName("org.h2.Driver")
  ConnectionPool.singleton("jdbc:postgresql://127.0.0.1/postgres", "postgres", )



  val ar = new AnagramRunner(Anatree("/words.txt"), new EvaluationRunner())

  register(new Api(ar))
  register(new Website(ar))
}
