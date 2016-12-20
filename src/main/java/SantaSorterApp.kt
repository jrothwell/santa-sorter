import io.dropwizard.Application
import io.dropwizard.setup.Environment
import language.LanguageController
import language.LanguageResource
import location.LocationController
import location.LocationResource
import parcel.ParcelController
import player.PlayerController
import player.PlayerResource

/**
 * Created by jrothwell on 18/12/2016.
 */

class SantaSorterApp : Application<SantaSorterConfig>() {
    override fun run(config: SantaSorterConfig, environment: Environment) {
        val languageController = LanguageController(config.languages)
        val locationController = LocationController(languageController)
        val parcelController = ParcelController(locationController)
        val playerController = PlayerController(parcelController)
        environment.jersey().register(LanguageResource(languageController))
        environment.jersey().register(LocationResource(locationController))
        environment.jersey().register(PlayerResource(playerController))
    }

}