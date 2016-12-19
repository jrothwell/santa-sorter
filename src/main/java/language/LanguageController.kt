package language

import com.google.common.io.Resources
import com.google.common.io.Resources.getResource
import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */
class LanguageController(private val availableLanguages: List<String>) {

    val languages = ArrayList<Language>()
    init {
        availableLanguages.forEach { languageCode ->
            val lines: List<List<String>> = Resources.readLines(getResource("languages/$languageCode.csv"), Charsets.UTF_8)
                    .map({ line -> line.split(",") })
            val (englishName, foreignName) = lines[0]
            val lang = Language(name = foreignName, englishName = englishName)
            lines.forEach { line -> lang.dictionary.put(line[1].toLowerCase(), line[0].toLowerCase()) }
            languages.add(lang)

        }
    }

    fun getLanguages() : List<String> = this.languages
               .map(Language::englishName)

    fun define(word: String, otherLanguage: String): String? {
        val language = this.languages
                .find({ language ->
                    language.englishName.toLowerCase() == otherLanguage.toLowerCase() })
        return language
                ?.dictionary?.get(word.toLowerCase())
    }
}