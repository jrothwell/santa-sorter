package parcel

import location.LocationController
import java.security.SecureRandom
import java.util.*

/**
 * Created by jrothwell on 20/12/2016.
 */
class ParcelController(private val locationController: LocationController) {
    fun getParcel(): Parcel {
        val randomCity = locationController.getRandomCity()
        val countryOfOrigin = locationController.getRandomCountry()
        val destinationCityString = countryOfOrigin.language.wordFor(randomCity.name)
        val destinationCountryString = countryOfOrigin.language.wordFor(randomCity.country.name)

        return Parcel(countryOfOrigin = countryOfOrigin,
                destination = randomCity,
                label = "${randomName()}\n$destinationCityString\n$destinationCountryString".toUpperCase(),
                id = UUID.randomUUID());
    }

    fun randomName(): String {
        val names = listOf<String>("Amelia", "Olivia", "Emily", "Poppy", "Ava",
                "Oliver", "Jack", "Harry", "Jacob", "Charlie",
                "Manon", "Jade", "Louise", "Alice", "Camille",
                "Armand", "Jules", "Lucas", "Léo", "Gabriel",
                "Emma", "Mia", "Hanna", "Sofia", "Emilia",
                "Ben", "Luis", "Paul", "Lukas", "Jonas",
                "Daan", "Sem", "Milan", "Levi", "Luuk",
                "Emma", "Julia", "Sophie", "Lotte", "Isa"
                )
        return names[SecureRandom().nextInt(names.count())]
    }
}