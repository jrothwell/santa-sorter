package parcel

import location.Coordinate

data class Answer(val parcelId: String,
                  val destination: Coordinate,
                  val correct: Boolean)