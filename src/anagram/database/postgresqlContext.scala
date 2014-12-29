package anagram.database

/**
 * Created by Random on 12/23/2014.
 */
import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.relational.PooledJdbcRelationalStorage
import net.fwbrasil.activate.storage.relational.idiom.postgresqlDialect

object postgresqlContext extends ActivateContext {
  val storage = new PooledJdbcRelationalStorage {
    val jdbcDriver = "org.postgresql.Driver"
    val user = Option("postgres")
    val password = Option("wotmania12")
    val url = "jdbc:postgresql://127.0.0.1/postgres"
    val dialect = postgresqlDialect
  }
}