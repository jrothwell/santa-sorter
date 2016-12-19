import io.dropwizard.Application
import io.dropwizard.setup.Environment
import language.LanguageController
import language.LanguageResource

/**
 * Created by jrothwell on 18/12/2016.
 */

class SantaSorterApp : Application<SantaSorterConfig>() {
    override fun run(config: SantaSorterConfig, environment: Environment) {
        val languageController = LanguageController()
        environment.jersey().register(LanguageResource(languageController))
    }

}