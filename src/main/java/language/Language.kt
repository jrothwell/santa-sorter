package language

import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */

class Language(val name: String,
               val englishName: String) {
    val dictionary = HashMap<String, String>()

    fun wordFor(englishWord: String): String? {
        return dictionary.get(englishWord)
    }
}
