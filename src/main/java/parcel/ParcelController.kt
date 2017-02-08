package parcel

import com.mongodb.client.MongoDatabase
import location.LocationController
import org.litote.kmongo.getCollection
import player.Player
import java.security.SecureRandom
import java.util.*

/**
 * Created by jrothwell on 20/12/2016.
 */
class ParcelController(private val locationController: LocationController,
                       private val mongoDatabase: MongoDatabase) {

    fun parcelForPlayer(player: Player): Parcel {
        val randomCity = locationController.getRandomCity()
        val countryOfOrigin = locationController.getRandomCountry()
        val destinationCityString = countryOfOrigin.language.wordFor(randomCity.name)
        val destinationCountryString = countryOfOrigin.language.wordFor(randomCity.country.name)

        val newParcel = Parcel(countryOfOriginName = countryOfOrigin.name,
                destination = randomCity,
                label = "${randomName()}\n$destinationCityString\n$destinationCountryString".toUpperCase(),
                id = UUID.randomUUID().toString(),
                playerId = player.id)

        mongoDatabase.getCollection<Parcel>().insertOne(newParcel)
        println(mongoDatabase.getCollection<Parcel>().count())
        return newParcel;
    }

    fun randomName(): String {
        val names = listOf<String>("Amelia", "Olivia", "Emily", "Poppy", "Ava",
                "Oliver", "Jack", "Harry", "Jacob", "Charlie",
                "Manon", "Jade", "Louise", "Alice", "Camille",
                "Armand", "Jules", "Lucas", "Léo", "Gabriel",
                "Emma", "Mia", "Hanna", "Sofia", "Emilia",
                "Ben", "Luis", "Paul", "Lukas", "Jonas",
                "Daan", "Sem", "Milan", "Levi", "Luuk",
                "Emma", "Julia", "Sophie", "Lotte", "Isa"
                )
        return names[SecureRandom().nextInt(names.count())]
    }
}