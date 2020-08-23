package com.jonathansantos.animaisfofos.services

import retrofit2.Call
import retrofit2.http.GET

interface BirdService {
    @GET("birds")
    fun getBirdPhoto(): Call<Array<String>>
}