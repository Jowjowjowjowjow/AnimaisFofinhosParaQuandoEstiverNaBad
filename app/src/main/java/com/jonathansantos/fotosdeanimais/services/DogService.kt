package com.jonathansantos.fotosdeanimais.services

import com.jonathansantos.fotosdeanimais.model.DogPhoto
import retrofit2.Call
import retrofit2.http.GET

interface DogService {
    @GET("woof.json")
    fun getDogPhoto(): Call<DogPhoto>
}