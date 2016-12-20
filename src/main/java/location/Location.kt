package location

import language.Language

/**
 * Created by jrothwell on 19/12/2016.
 */
data class Country(val name: String,
                   val language: Language)

data class City(val name: String,
                val location: Coordinate,
                val country: Country)

data class Coordinate(val latitude: degreesMins,
                      val longitude: degreesMins)

data class degreesMins(val degrees: Int,
                       val minutes: Int,
                       val direction: Direction)

enum class Direction {NORTH, SOUTH, EAST, WEST}