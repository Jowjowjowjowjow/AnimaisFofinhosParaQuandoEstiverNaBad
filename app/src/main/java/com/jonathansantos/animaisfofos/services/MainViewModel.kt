package com.jonathansantos.animaisfofos.services

import androidx.lifecycle.ViewModel
import com.jonathansantos.animaisfofos.MainActivity
import com.jonathansantos.animaisfofos.extensions.cleanUrl
import com.jonathansantos.animaisfofos.model.CatPhoto
import com.jonathansantos.animaisfofos.model.DogPhoto
import com.jonathansantos.animaisfofos.model.DuckPhoto
import com.jonathansantos.animaisfofos.model.FoxPhoto
import com.jonathansantos.animaisfofos.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(val mainActivity: MainActivity) : ViewModel() {
    private var call = RetrofitInitializer()

    fun getDogPhotoUrl() {
        call.dogService().getDogPhoto().enqueue(object : Callback<DogPhoto?> {
            override fun onFailure(call: Call<DogPhoto?>, error: Throwable) {
                throw Throwable(cause = error.cause)
            }

            override fun onResponse(call: Call<DogPhoto?>, response: Response<DogPhoto?>) {
                response.body()?.let {
                    if (it.url.endsWith("mp4"))
                        getDogPhotoUrl()
                    else
                        mainActivity.showProgressAndFillPhoto(it.url.cleanUrl)
                }
            }
        })

    }

    fun getCatPhotoUrl() {
        call.catService().getCatPhoto().enqueue(object : Callback<CatPhoto?> {
            override fun onFailure(call: Call<CatPhoto?>, error: Throwable) {
                throw Throwable(cause = error.cause)
            }

            override fun onResponse(call: Call<CatPhoto?>, response: Response<CatPhoto?>) {
                response.body()?.let {
                    if (it.file.endsWith("mp4"))
                        getCatPhotoUrl()
                    else
                        mainActivity.showProgressAndFillPhoto(it.file.cleanUrl)
                }
            }
        })
    }

    fun getFoxPhotoUrl() {
        call.foxService().getFoxPhoto().enqueue(object : Callback<FoxPhoto?> {
            override fun onFailure(call: Call<FoxPhoto?>, error: Throwable) {
                throw Throwable(cause = error.cause)
            }

            override fun onResponse(call: Call<FoxPhoto?>, response: Response<FoxPhoto?>) {
                response.body()?.let {
                    if (it.image.endsWith("mp4"))
                        getFoxPhotoUrl()
                    else
                        mainActivity.showProgressAndFillPhoto(it.image.cleanUrl)
                }
            }
        })
    }

    fun getDuckPhotoUrl() {
        call.duckService().getDuckPhoto().enqueue(object : Callback<DuckPhoto?> {
            override fun onFailure(call: Call<DuckPhoto?>, error: Throwable) {
                throw Throwable(cause = error.cause)
            }

            override fun onResponse(call: Call<DuckPhoto?>, response: Response<DuckPhoto?>) {
                response.body()?.let {
                    if (it.url.endsWith("mp4"))
                        getDuckPhotoUrl()
                    else
                        mainActivity.showProgressAndFillPhoto(it.url.cleanUrl)
                }
            }
        })
    }

    fun getBirdPhotoUrl() {
        call.birdService().getBirdPhoto().enqueue(object : Callback<Array<String>?> {
            override fun onFailure(call: Call<Array<String>?>, error: Throwable) {
                throw Throwable(cause = error.cause)
            }

            override fun onResponse(
                call: Call<Array<String>?>,
                response: Response<Array<String>?>
            ) {
                response.body()?.let {
                    if (it[0].endsWith("mp4"))
                        getBirdPhotoUrl()
                    else
                        mainActivity.showProgressAndFillPhoto(it[0].cleanUrl)
                }
            }
        })
    }
}