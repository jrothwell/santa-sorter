package language

import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */

class Language(val name: String,
               val englishName: String) {
    private val dictionary = HashMap<String, String>()

    fun wordFor(englishWord: String): String? {
        return dictionary.toList()
                .find { it.second == englishWord.toLowerCase() }
                ?.first
    }

    fun define(word: String): String? {
        return dictionary.get(word.toLowerCase())
    }

    fun addDefinition(foreign: String, english: String) {
        dictionary.put(foreign.toLowerCase(), english.toLowerCase())
    }
}
