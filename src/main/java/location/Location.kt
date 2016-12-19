package location

import language.Language

/**
 * Created by jrothwell on 19/12/2016.
 */
data class Country(val name: String,
                   val language: Language)

data class City(val name: String,
                val location: Coordinate,
                val radius: Int)

data class Coordinate(val x: Double,
                      val y: Double)