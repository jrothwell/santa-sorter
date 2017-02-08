package language

import java.util.*

class Language(val name: String,
               val englishName: String) {
    private val dictionary: HashMap<String, String> = HashMap<String, String>()

    fun wordFor(englishWord: String): String? = dictionary.toList()
            .find { it.second == englishWord.toLowerCase() }
            ?.first

    fun define(word: String): String? = dictionary.get(word.toLowerCase())

    fun addDefinition(foreign: String, english: String) {
        dictionary.put(foreign.toLowerCase(), english.toLowerCase())
    }
}
