import io.dropwizard.Application
import io.dropwizard.setup.Environment
import language.LanguageController
import language.LanguageResource
import location.LocationController
import location.LocationResource
import org.litote.kmongo.KMongo
import parcel.ParcelController
import player.PlayerController
import player.PlayerResource

class SantaSorterApp : Application<SantaSorterConfig>() {
    override fun run(config: SantaSorterConfig, environment: Environment) {
        val databaseClient = KMongo.createClient()
        val database = databaseClient.getDatabase("santa")
        database.drop() // delete everything - start fresh every time we run the server

        val languageController = LanguageController(config.languages)
        val locationController = LocationController(languageController)
        val parcelController = ParcelController(locationController, database)
        val playerController = PlayerController(parcelController)
        environment.jersey().register(LanguageResource(languageController))
        environment.jersey().register(LocationResource(locationController))
        environment.jersey().register(PlayerResource(playerController))
    }

}