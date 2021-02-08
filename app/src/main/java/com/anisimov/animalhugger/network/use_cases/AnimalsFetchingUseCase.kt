package com.anisimov.animalhugger.network.use_cases

import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.model.Animals
import com.anisimov.animalhugger.network.api.AnimalsApi
import io.reactivex.Flowable

class AnimalsFetchingUseCase(
    private val animalsApi: AnimalsApi
) {

    operator fun invoke(): Flowable<List<Animals>> =
        animalsApi
            .getAnimals()
            .map { response ->
                response.map { animals ->
                    Animals(
                        species = animals.species,
                        specimens = animals.specimens.map { specimen ->
                            Animal(
                                id = specimen.id,
                                name = specimen.name,
                                description = specimen.description,
                                imageUrl = specimen.image_url,
                            )
                        }
                    )
                }
            }

}
