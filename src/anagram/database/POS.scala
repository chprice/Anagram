package anagram.database

import postgresqlContext._

/**
 * Created by Random on 12/23/2014.
 */
class POS(
         var sequence: String, // "NN VB" //space separated string of POS tags
         var count: Int
           ) extends Entity


/*class CreatePOSTableMigration extends Migration {
  def timestamp = System.currentTimeMillis / 1000
  def up() = {
    table[POS]
      .createTable(
        _.column[String]("sequence"),
        _.column[Int]("count"))
  }
}*/