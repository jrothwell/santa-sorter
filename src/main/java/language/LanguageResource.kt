package language

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

/**
 * Created by jrothwell on 19/12/2016.
 */

@Produces(APPLICATION_JSON)
@Path("languages")
class LanguageResource(val controller: LanguageController) {

    @GET
    fun getLanguages() : List<String> = controller.getLanguages()

    @Path("{language}/{word}")
    @GET
    fun whatIs(@PathParam("language") language: String,
               @PathParam("word") word: String): String? {
        return controller.whatIs(word, language)
    }
}