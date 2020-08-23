package com.jonathansantos.animaisfofos.services

import com.jonathansantos.animaisfofos.model.FoxPhoto
import retrofit2.Call
import retrofit2.http.GET

interface FoxService {
    @GET("floof")
    fun getFoxPhoto(): Call<FoxPhoto>
}