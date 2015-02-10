package anagram.database


import scalikejdbc._

/**
 * Created by Random on 12/23/2014.
 */
class POS(
         var sequence: String, // "NN VB" //space separated string of POS tags
         var count: Int
           )

object POS extends SQLSyntaxSupport[POS] {
  override val tableName = "pos"
  def apply(rs: WrappedResultSet) = new POS(
    rs.string("sequence"), rs.int("count")
  )
}