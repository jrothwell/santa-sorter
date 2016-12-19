package parcel

import location.City
import location.Country

/**
 * Created by jrothwell on 19/12/2016.
 */

data class Parcel(val countryOfOrigin: Country,
                  val destination: City,
                  val label: String)

