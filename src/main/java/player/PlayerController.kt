package player

import location.Coordinate
import parcel.Parcel
import parcel.ParcelController
import java.util.*

/**
 * Created by jrothwell on 20/12/2016.
 */
class PlayerController(private val parcelController: ParcelController) {
    private val players = ArrayList<Player>()

    fun getPlayer(playerName: String): Player {
        var playerMaybe = players.find { player -> player.id == playerName }
        if (playerMaybe == null) {
            playerMaybe = Player(playerName)
            players.add(playerMaybe)
        }
        return playerMaybe
    }

    fun getNewParcelForPlayer(playerName: String): Parcel? {
        val parcel = this.parcelController.parcelForPlayer(getPlayer(playerName))
        getPlayer(playerName).parcels.add(parcel)
        return parcel
    }

    fun getUnansweredParcels(playerName: String): List<Parcel> = getPlayer(playerName).parcels
            .filter{parcel -> !parcel.answered()}

    fun answerParcel(playerName: String, parcelId: String, destination: Coordinate) {
        getPlayer(playerName)
                .getParcel(parcelId)
                ?.answer(destination)
    }

    fun getPlayers(): ArrayList<Player> = this.players
}
