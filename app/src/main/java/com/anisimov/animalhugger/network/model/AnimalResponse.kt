package com.anisimov.animalhugger.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimalResponse(
    val id: Int,
    val name: String,
    val description: String,
)
