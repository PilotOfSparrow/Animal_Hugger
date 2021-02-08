package com.anisimov.animalhugger.ui.main

import com.airbnb.mvrx.MavericksViewModel
import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.model.Animals
import com.anisimov.animalhugger.network.NetworkModule
import com.anisimov.animalhugger.network.api.mock.AnimalsApiMock
import com.anisimov.animalhugger.network.use_cases.AnimalsFetchingUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject

class MainViewModel(initialState: MainState) : MavericksViewModel<MainState>(initialState) {

    private val animalsSubject = BehaviorSubject.create<List<Animals>>()

    private var animalsDisposable: Disposable? = null

    init {
        AnimalsFetchingUseCase(AnimalsApiMock())
            .invoke()
            .doOnNext(animalsSubject::onNext)
            .doOnError(::println)
            .subscribe()

        animalsDisposable = animalsSubject.subscribe { listOfAnimals ->
            setState {
                MainState(
                    animals = listOfAnimals,
                    featuredSpecies = listOfAnimals.take(4).map(Animals::species),
                    availableSpecies = listOfAnimals.map(Animals::species),
                )
            }
        }
    }

    override fun onCleared() {
        animalsDisposable?.dispose()

        super.onCleared()
    }

}
