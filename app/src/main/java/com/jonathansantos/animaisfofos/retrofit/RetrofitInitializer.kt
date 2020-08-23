package com.jonathansantos.animaisfofos.retrofit

import com.jonathansantos.animaisfofos.services.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val dogApi = "https://random.dog/"
    private val foxApi = "https://randomfox.ca/"
    private val catApi = "https://aws.random.cat/"
    private val duckApi = "https://random-d.uk/api/v2/"
    private val birdApi = "http://shibe.online/api/"


    private fun retrofit(api: String): Retrofit = Retrofit.Builder()
        .baseUrl(api)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun dogService(): DogService = retrofit(dogApi).create(DogService::class.java)
    fun catService(): CatService = retrofit(catApi).create(CatService::class.java)
    fun foxService(): FoxService = retrofit(foxApi).create(FoxService::class.java)
    fun duckService(): DuckService = retrofit(duckApi).create(DuckService::class.java)
    fun birdService(): BirdService = retrofit(birdApi).create(BirdService::class.java)
}