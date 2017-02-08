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

    fun getNewParcelForPlayer(playerName: String): Parcel {
        return this.parcelController.parcelForPlayer(getPlayer(playerName))
    }

    fun answerParcel(playerName: String, parcelId: String, destination: Coordinate) {
        parcelController.answerParcel(playerId = playerName,
                parcelId = parcelId,
                destination = destination)
    }

    fun getScore(playerName: String) : Int = parcelController.getTotalScore(playerName)

    fun getPlayers(): ArrayList<Player> = this.players
    fun  getAnsweredParcels(playerId: String): Int = parcelController.getAnsweredParcelsCount(playerId)
    fun  getRequestedParcels(playerId: String): Int = parcelController.getRequestedParcelsCount(playerId)
}
