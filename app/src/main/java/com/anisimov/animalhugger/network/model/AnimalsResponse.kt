package com.anisimov.animalhugger.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimalsResponse(
    val species: String,
    val specimens: List<AnimalResponse>
)
