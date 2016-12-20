package player

import parcel.Parcel
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
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
}