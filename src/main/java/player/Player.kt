package player

import parcel.Parcel
import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */
class Player(val id: String) {
    val parcels = HashSet<Parcel>()

    fun getParcel(parcelId: String): Parcel? = this.parcels.find { parcel -> parcel.id == parcelId }

    fun getScore(): Int = parcels.filter(Parcel::isCorrect).count() * 100 -
            parcels.filter { parcel -> parcel.answered() && !parcel.isCorrect() }.count() * 150

    fun parcelsAnswered(): Int = parcels.filter(Parcel::answered)
            .count()

    fun parcelsRequested(): Int = parcels.count()
}