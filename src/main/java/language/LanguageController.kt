package language

import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */
class LanguageController {
    val languages = ArrayList<Language>()
    init {
        val french = Language("Français", "French")
        french.dictionary.put( "parcelle", "parcel")
        french.dictionary.put( "la France", "France")
        french.dictionary.put( "le Royaume-Uni", "United Kingdom")
        french.dictionary.put( "l'Allemagne", "Germany")
        french.dictionary.put( "l'Irlande", "Ireland")
        french.dictionary.put( "l'Espagne", "Spain")
        french.dictionary.put( "l'Italie", "Italy")
        french.dictionary.put( "les Pays-Bas", "Netherlands")
        french.dictionary.put( "la Suisse", "Switzerland")
        french.dictionary.put( "la Belgique", "Belgium")
        french.dictionary.put( "l'Autriche", "Austria")
        french.dictionary.put( "la Republique Tcheque", "Czech Republic")
        french.dictionary.put( "le Danemark", "Denmark")
        french.dictionary.put( "la Suede", "Sweden")
        french.dictionary.put( "la Norveige", "Norway")
        french.dictionary.put( "la Finlande", "Finland")
        languages.add(french)
    }

    fun getLanguages() : List<String> = this.languages
               .map(Language::englishName)

    fun whatIs(word: String, otherLanguage: String): String? = this.languages
            .find({ language -> language.englishName.equals(otherLanguage) })
            ?.dictionary?.get(word)
}