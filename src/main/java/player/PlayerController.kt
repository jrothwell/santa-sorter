package player

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
        val parcel = this.parcelController.getParcel()
        getPlayer(playerName)?.unsortedParcels?.add(parcel)
        return parcel
    }
}
