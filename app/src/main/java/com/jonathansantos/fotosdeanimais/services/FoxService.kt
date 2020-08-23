package com.jonathansantos.fotosdeanimais.services

import com.jonathansantos.fotosdeanimais.model.FoxPhoto
import retrofit2.Call
import retrofit2.http.GET

interface FoxService {
    @GET("floof")
    fun getFoxPhoto(): Call<FoxPhoto>
}