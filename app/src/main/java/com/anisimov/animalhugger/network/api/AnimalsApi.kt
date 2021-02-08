package com.anisimov.animalhugger.network.api

import com.anisimov.animalhugger.network.model.AnimalsResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface AnimalsApi {

    @GET("animals")
    fun getAnimals(): Flowable<List<AnimalsResponse>>

}
