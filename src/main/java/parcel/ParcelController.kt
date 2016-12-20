package parcel

import location.LocationController
import java.util.*

/**
 * Created by jrothwell on 20/12/2016.
 */
class ParcelController(private val locationController: LocationController) {
    fun getParcel() : Parcel {
        return Parcel(countryOfOrigin = locationController.getCountry("Germany")!!,
                destination = locationController.getCity("Paris")!!,
                label = "Timmy Jones\nParis\nFrankreich",
                id = UUID.randomUUID());
    }
}