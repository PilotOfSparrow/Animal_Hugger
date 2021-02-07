package com.anisimov.animalhugger.ui.main

import androidx.lifecycle.ViewModel
import com.airbnb.mvrx.MavericksViewModel
import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.model.Animals

class MainViewModel(initialState: MainState) : MavericksViewModel<MainState>(initialState) {

    init {
        setState {
            val animals = listOf(
                Animals("Cats", (0..20).map { Animal(it, "Cat $it", "Description of cat: $it") }),
                Animals("Dogs", (0..20).map { Animal(it, "Dog $it", "Description of dog: $it") }),
                Animals("Cow", (0..20).map { Animal(it, "Cow $it", "Description of cow: $it") }),
                Animals("Crow", (0..20).map { Animal(it, "Crow $it", "Description of crow: $it") }),
                Animals("Sparrow", (0..20).map { Animal(it, "Sparrow $it", "Description of sparrow: $it") }),
                Animals("Something", (0..20).map { Animal(it, "Something $it", "Description of something: $it") }),
                Animals("Octopus", (0..20).map { Animal(it, "Octopus $it", "Description of octopus: $it") }),
                Animals("Mailman", (0..20).map { Animal(it, "Mailman $it", "Description of mailman: $it") }),
                Animals("Lolis", (0..20).map { Animal(it, "Lolis $it", "Description of lolis: $it") }),
            )

            MainState(
                animals = animals,
                featuredSpecies = animals.take(4).map(Animals::species),
                availableSpecies = animals.map(Animals::species),
            )
        }
    }

}
