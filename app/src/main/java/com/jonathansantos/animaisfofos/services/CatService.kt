package com.jonathansantos.animaisfofos.services

import com.jonathansantos.animaisfofos.model.CatPhoto
import retrofit2.Call
import retrofit2.http.GET

interface CatService {
    @GET("meow")
    fun getCatPhoto(): Call<CatPhoto>
}