package parcel

import location.City
import location.Coordinate

/**
 * Created by jrothwell on 19/12/2016.
 */

class Parcel(val countryOfOriginName: String,
             val destination: City,
             val label: String,
             val id: String,
             val playerId: String) {
    private var destinationCoordinate: Coordinate? = null

    fun answer(answerCoordinate: Coordinate) {
        this.destinationCoordinate = answerCoordinate
    }

    fun answered(): Boolean = this.destinationCoordinate != null

    fun isCorrect(): Boolean = this.destinationCoordinate?.equals(this.destination.location) ?: false

}

