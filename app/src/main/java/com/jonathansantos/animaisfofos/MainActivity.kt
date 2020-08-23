package com.jonathansantos.animaisfofos

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jonathansantos.animaisfofos.services.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mainViewModel: MainViewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_dogPhoto.setOnClickListener {
            mainViewModel.getDogPhotoUrl()
        }

        bt_catPhoto.setOnClickListener {
            mainViewModel.getCatPhotoUrl()
        }

        bt_foxPhoto.setOnClickListener {
            mainViewModel.getFoxPhotoUrl()
        }

        bt_duckPhoto.setOnClickListener {
            mainViewModel.getDuckPhotoUrl()
        }

        bt_birdPhoto.setOnClickListener {
           mainViewModel.getBirdPhotoUrl()
        }

        bt_randomPhoto.setOnClickListener {
            fillWithRandomPhoto()
        }
    }

    private fun fillWithRandomPhoto(){
        when((1..5).random()){
            1 -> mainViewModel.getDogPhotoUrl()
            2 -> mainViewModel.getCatPhotoUrl()
            3 -> mainViewModel.getFoxPhotoUrl()
            4 -> mainViewModel.getDuckPhotoUrl()
            5 -> mainViewModel.getBirdPhotoUrl()
        }
    }

    fun showProgressAndFillPhoto(url: String){
        try {
            showProgressBar()
            fillPhoto(url)
        } catch (error: Throwable) {
            logError(error)
            hideProgressBar()
        } catch (exception : Exception){
            logError(Throwable(exception.toString()))
            hideProgressBar()
        }
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun logError(error: Throwable) {
        Toast.makeText(
            this@MainActivity,
            "Poxa, ocorreu um erro :(",
            Toast.LENGTH_SHORT
        ).show()
        Log.e("Error", error.toString())
    }

    private fun fillPhoto(url: String) {
        Picasso.get().load(url).into(iv_photo, object : com.squareup.picasso.Callback {
            override fun onSuccess() {
                if (progressBar != null) {
                    progressBar.visibility = View.GONE
                }
            }

            override fun onError(e: Exception?) {
                if (progressBar != null) {
                    progressBar.visibility = View.GONE
                }
                logError(Throwable(e))
            }
        })
    }
}