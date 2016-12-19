package player

import parcel.Parcel
import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */
class Player(val id: String) {
    val parcelQueue = PriorityQueue<Parcel>()
}