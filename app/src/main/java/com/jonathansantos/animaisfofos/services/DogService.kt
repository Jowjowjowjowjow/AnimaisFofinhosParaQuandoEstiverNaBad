package com.jonathansantos.animaisfofos.services

import com.jonathansantos.animaisfofos.model.DogPhoto
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("woof.json")
    fun getDogPhoto(): Call<DogPhoto>
}