package language

import java.util.Collections.singletonMap
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON

/**
 * Created by jrothwell on 19/12/2016.
 */

@Produces(APPLICATION_JSON)
@Path("languages")
class LanguageResource(val controller: LanguageController) {

    @GET
    fun getLanguages() : List<String> = controller.getLanguages()

    @Path("{language}/define/{word}")
    @GET
    fun whatIs(@PathParam("language") language: String,
               @PathParam("word") word: String): Map<String, String> =
            singletonMap("definition",
                    controller.define(word, language) ?:
                    throw NotFoundException("No definition for $word in $language"))
}