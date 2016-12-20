package player

import location.Coordinate
import location.Direction
import location.degreesMins
import parcel.Parcel
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import kotlin.comparisons.compareBy

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
                     @PathParam("id") parcelId: String,
                     destination: Map<*, *>) {
        val latitude = destination["latitude"] as? Map<*, *>
        val latitudeCoordinate = degreesMins((latitude?.get("degrees") as? Int)!!,
                (latitude?.get("minutes") as? Int)!!,
                Direction.valueOf((latitude?.get("direction") as? String)!!))
        val longitude = destination.get("longitude") as? Map<*, *>
        val longitudeCoordinate = degreesMins((longitude?.get("degrees") as? Int)!!,
                (longitude?.get("minutes") as? Int)!!,
                Direction.valueOf((longitude?.get("direction") as? String)!!))
        val coord = Coordinate(latitudeCoordinate, longitudeCoordinate)

        playerController.answerParcel(player, UUID.fromString(parcelId), coord) // TODO FIX ME
    }

    @GET
    @Path("{player}/score")
    fun getScore(@PathParam("player") player: String): Int {
        return playerController.getPlayer(player).getScore()
    }

    @GET
    fun getPlayers(): List<Map<String, *>> {
        return playerController.getPlayers()
                .sortedWith(compareBy(Player::getScore))
                .map {
                    mapOf("name" to it.id,
                            "score" to it.getScore())
                }
    }
}