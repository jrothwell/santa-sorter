package location

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Created by jrothwell on 19/12/2016.
 */

@Produces(MediaType.APPLICATION_JSON)
@Path("location")
class LocationResource(private val controller: LocationController) {
    @GET
    @Path("countries")
    fun getCountries() : List<Country> = controller.getCountries()

    @GET
    @Path("countries/{country}/cities")
    fun getCities(@PathParam("country") country : String) : List<City> = controller.getCities()
            .filter { city -> city.country == controller.getCountry(country) ?: throw NotFoundException() }
}