package location

import language.LanguageController
import location.Direction.*
import java.util.*

/**
 * Created by jrothwell on 19/12/2016.
 */

class LocationController(private val languageController: LanguageController) {
    private val countries: List<Country> = listOf(
            Country(name = "United Kingdom", language = languageController.getLanguage("English")!!),
            Country(name = "France", language = languageController.getLanguage("French")!!),
            Country(name = "Germany", language = languageController.getLanguage("German")!!),
            Country(name = "Netherlands", language = languageController.getLanguage("Dutch")!!)
            )

    fun getCountry(name: String) : Country? = this.countries
            .find { country -> country.name == name }

    private val cities: List<City> = listOf(
            City(name = "London",
                    location = Coordinate(degreesMins(51, 30, NORTH), degreesMins(0, 7, WEST)),
                    country = getCountry("United Kingdom")!!),
            City(name = "Manchester",
                    location = Coordinate(degreesMins(53, 28, NORTH), degreesMins(2, 14, WEST)),
                    country = getCountry("United Kingdom")!!),
            City(name = "Cardiff",
                    location = Coordinate(degreesMins(51, 29, NORTH), degreesMins(3, 11, WEST)),
                    country = getCountry("United Kingdom")!!),
            City(name = "Glasgow",
                    location = Coordinate(degreesMins(55, 51, NORTH), degreesMins(4, 15, WEST)),
                    country = getCountry("United Kingdom")!!),
            City(name = "Belfast",
                    location = Coordinate(degreesMins(54, 35, NORTH), degreesMins(5, 55, WEST)),
                    country = getCountry("United Kingdom")!!),
            City(name = "Paris",
                    location = Coordinate(degreesMins(48, 51, NORTH), degreesMins(2, 21, EAST)),
                    country = getCountry("France")!!),
            City(name = "Berlin",
                    location = Coordinate(degreesMins(52, 31, NORTH), degreesMins(13, 23, EAST)),
                    country = getCountry("Germany")!!),
            City(name = "Amsterdam",
                    location = Coordinate(degreesMins(52, 22, NORTH), degreesMins(4, 54, EAST)),
                    country = getCountry("Netherlands")!!)
            )

    fun getCities() : List<City> = this.cities

    fun getCity(name: String) : City? = this.cities
            .find { city -> city.name == name }

    fun getCountries(): List<Country> = this.countries

}