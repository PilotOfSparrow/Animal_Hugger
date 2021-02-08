package com.anisimov.animalhugger.network.api.mock

import com.anisimov.animalhugger.network.api.AnimalsApi
import com.anisimov.animalhugger.network.model.AnimalResponse
import com.anisimov.animalhugger.network.model.AnimalsResponse
import io.reactivex.Flowable

class AnimalsApiMock : AnimalsApi {

    override fun getAnimals(): Flowable<List<AnimalsResponse>> =
        Flowable.just(
            listOf(
                AnimalsResponse(
                    "Cats",
                    (0..20).map { AnimalResponse(it, "Cat $it", "Description of cat: $it") }),
                AnimalsResponse(
                    "Dogs",
                    (0..20).map { AnimalResponse(it, "Dog $it", "Description of dog: $it") }),
                AnimalsResponse(
                    "Cow",
                    (0..20).map { AnimalResponse(it, "Cow $it", "Description of cow: $it") }),
                AnimalsResponse(
                    "Crow",
                    (0..20).map { AnimalResponse(it, "Crow $it", "Description of crow: $it") }),
                AnimalsResponse(
                    "Sparrow",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Sparrow $it",
                            "Description of sparrow: $it"
                        )
                    }),
                AnimalsResponse(
                    "Something",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Something $it",
                            "Description of something: $it"
                        )
                    }),
                AnimalsResponse(
                    "Octopus",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Octopus $it",
                            "Description of octopus: $it"
                        )
                    }),
                AnimalsResponse(
                    "Mailman",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Mailman $it",
                            "Description of mailman: $it"
                        )
                    }),
                AnimalsResponse(
                    "Lolis",
                    (0..20).map { AnimalResponse(it, "Lolis $it", "Description of lolis: $it") }),
            )
        )
}
