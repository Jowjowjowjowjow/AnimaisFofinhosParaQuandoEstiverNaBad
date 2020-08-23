package com.jonathansantos.fotosdeanimais.services

import com.jonathansantos.fotosdeanimais.model.DuckPhoto
import retrofit2.Call
import retrofit2.http.GET

interface DuckService {
    @GET("quack")
    fun getDuckPhoto(): Call<DuckPhoto>
}