package player

import location.Coordinate
import location.Direction
import location.degreesMins
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
    fun getParcel(@PathParam("player") player : String) : Map<String, *> {
        val parcel = playerController.getNewParcelForPlayer(player)
        return mapOf(
                "id" to parcel.id,
                "playerId" to parcel.playerId,
                "label" to parcel.label,
                "countryOfOrigin" to parcel.countryOfOriginName
        )

    }

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

        playerController.answerParcel(player, parcelId, coord) // TODO FIX ME
    }

    @GET
    @Path("{player}/score")
    fun getScore(@PathParam("player") player: String): Int {
        return playerController.getScore(player)
    }

    @GET
    fun getPlayers(): List<Map<String, *>> {
        return playerController.getPlayers()
                .sortedWith(compareBy(Player::getScore))
                .map {
                    mapOf("name" to it.id,
                            "score" to playerController.getScore(it.id),
                            "answeredParcels" to playerController.getAnsweredParcels(it.id),
                            "parcelsRequested" to playerController.getRequestedParcels(it.id))
                }
    }
}