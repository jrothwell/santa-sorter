package player

import location.Coordinate
import parcel.Parcel
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * Created by jrothwell on 20/12/2016.
 */
@Path("play")
@Produces(MediaType.APPLICATION_JSON)
class PlayerResource(private val playerController: PlayerController) {

    @GET
    @Path("{player}/get-parcel")
    fun getParcel(@PathParam("player") player : String) : Parcel? = playerController.getNewParcelForPlayer(player)

    @POST
    @Path("{player}/parcels/{id}")
    fun answerParcel(@PathParam("player") player: String,
                     @PathParam("id") parcelId: UUID,
                     @NotNull @Valid destination: Coordinate) {
        playerController.answerParcel(player, parcelId, destination) // TODO FIX ME
    }
}