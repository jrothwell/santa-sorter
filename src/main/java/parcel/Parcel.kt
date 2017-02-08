package parcel

import location.City
import location.Coordinate
import location.Country
import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */

class Parcel(val countryOfOrigin: Country,
             private val destination: City,
             val label: String,
             val id: String,
             val playerId: String) {
    private var destinationCoordinate: Coordinate? = null

    fun answer(answerCoordinate: Coordinate) {
        this.destinationCoordinate = answerCoordinate
    }

    fun answered(): Boolean = this.destinationCoordinate != null

    fun isCorrect(): Boolean {
        return this.destinationCoordinate?.equals(this.destination.location) ?: false
    }

}

