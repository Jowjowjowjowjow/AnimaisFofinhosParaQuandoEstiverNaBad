package com.jonathansantos.animaisfofos.services

import com.jonathansantos.animaisfofos.model.DuckPhoto
import retrofit2.Call
import retrofit2.http.GET

interface DuckService {
    @GET("quack")
    fun getDuckPhoto(): Call<DuckPhoto>
}