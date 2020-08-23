package com.jonathansantos.fotosdeanimais

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jonathansantos.fotosdeanimais.extensions.cleanUrl
import com.jonathansantos.fotosdeanimais.model.CatPhoto
import com.jonathansantos.fotosdeanimais.model.DogPhoto
import com.jonathansantos.fotosdeanimais.model.FoxPhoto
import com.jonathansantos.fotosdeanimais.retrofit.RetrofitInitializer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var call = RetrofitInitializer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_dogPhoto.setOnClickListener {
            showProgressBar()
            getDogPhoto()
        }

        bt_catPhoto.setOnClickListener {
            showProgressBar()
            getCatPhoto()
        }

        bt_foxPhoto.setOnClickListener {
            showProgressBar()
            getFoxPhoto()
        }


    }

    private fun getDogPhoto() {
        call.dogService().getDogPhoto().enqueue(object : Callback<DogPhoto?> {
            override fun onFailure(call: Call<DogPhoto?>, error: Throwable) {
                logError(error)
            }

            override fun onResponse(call: Call<DogPhoto?>, response: Response<DogPhoto?>) {
                response.body()?.let {
                    if (it.url.endsWith("mp4")) getDogPhoto() else fillPhoto(it.url)
                }
            }
        })
    }

    private fun getCatPhoto() {
        call.catService().getCatPhoto().enqueue(object : Callback<CatPhoto?> {
            override fun onFailure(call: Call<CatPhoto?>, error: Throwable) {
                logError(error)
            }

            override fun onResponse(call: Call<CatPhoto?>, response: Response<CatPhoto?>) {
                response.body()?.let {
                    if (it.file.endsWith("mp4")) getDogPhoto() else fillPhoto(it.file.cleanUrl)
                }
            }
        })
    }

    private fun getFoxPhoto() {
        call.foxService().getFoxPhoto().enqueue(object : Callback<FoxPhoto?> {
            override fun onFailure(call: Call<FoxPhoto?>, error: Throwable) {
                logError(error)
            }

            override fun onResponse(call: Call<FoxPhoto?>, response: Response<FoxPhoto?>) {
                response.body()?.let {
                    if (it.image.endsWith("mp4")) getDogPhoto() else fillPhoto(it.image.cleanUrl)
                }
            }
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun logError(error: Throwable) {
        Toast.makeText(
            this@MainActivity,
            "Poxa, ocorreu um erro :(",
            Toast.LENGTH_SHORT
        ).show()
        Log.e("Error", error.cause.toString())
    }

    private fun fillPhoto(url: String) {
        Picasso.get().load(url).into(iv_photo, object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                if (progressBar != null){
                    progressBar.visibility = View.GONE
                }
            }

            override fun onError(e: Exception?) {
                if (progressBar != null){
                    progressBar.visibility = View.GONE
                }
                logError(Throwable(e))
            }

        })
    }

}