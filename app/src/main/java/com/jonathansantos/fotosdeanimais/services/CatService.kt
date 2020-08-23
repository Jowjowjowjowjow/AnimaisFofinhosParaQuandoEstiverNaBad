package com.jonathansantos.fotosdeanimais.services

import com.jonathansantos.fotosdeanimais.model.CatPhoto
import retrofit2.Call
import retrofit2.http.GET

interface CatService {
    @GET("meow")
    fun getCatPhoto(): Call<CatPhoto>
}