package main.database

import postgresqlContext._

/**
 * Created by Random on 12/23/2014.
 */
class POS(
         var sequence: String, // "NN VB" //space separated string of POS tags
         var count: Int
           ) extends Entity