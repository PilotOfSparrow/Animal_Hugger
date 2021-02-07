package com.anisimov.animalhugger.ui.main

import com.airbnb.mvrx.MavericksState
import com.anisimov.animalhugger.model.Animals

data class MainState(
    val animals: List<Animals> = emptyList(),
    val featuredSpecies: List<String> = emptyList(),
    val availableSpecies: List<String> = emptyList(),
) : MavericksState
