package parcel

import com.mongodb.client.MongoDatabase
import location.Coordinate
import location.LocationController
import org.litote.kmongo.find
import org.litote.kmongo.findOne
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

    fun answerParcel(playerId: String, parcelId: String, destination: Coordinate) {
        val answersCollection = mongoDatabase.getCollection<Answer>()
        if(answersCollection.findOne("{parcelId: \"$parcelId\"}") != null) // we already have an answer
            return
        val filter = "{id: \"$parcelId\", playerId: \"$playerId\"}"
        val parcel = mongoDatabase.getCollection<Parcel>().findOne(filter) ?: throw Error("Couldn't find parcel!")
        parcel.answer(answerCoordinate = destination)
        answersCollection
                     .insertOne(Answer(parcelId = parcelId, destination = destination, correct = parcel.isCorrect()))
    }

    fun getTotalScore(playerId: String) : Int {
        val correctAnswers = mongoDatabase.getCollection<Answer>()
                .find("{correct: true}")
                .count()

        val incorrectAnswers = mongoDatabase.getCollection<Answer>()
                .find("{correct: false}")
                .count()

        return correctAnswers * 100 - incorrectAnswers * 150
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