package language

import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */

class Language(val name: String,
               val englishName: String) {
    private val dictionary = HashMap<String, String>()

    fun wordFor(englishWord: String): String? {
        return dictionary.get(englishWord)
    }

    fun define(word: String): String? {
        return dictionary.get(word)
    }

    fun addDefinition(english: String, other: String) {
        dictionary.put(english, other)
    }
}
