package me.alexnaupay.jetpackexample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    // MutableLiveData
    private var urlImage: MutableLiveData<String>? = null

    fun callUrlImage(): MutableLiveData<String>? {
        if (urlImage == null){
            urlImage = MutableLiveData<String>()
            //setRandomUrl()
        }
        return urlImage
    }

    fun setRandomUrl(){
        val randomNumber = (3..5).random().toString()
        val url = "https://picsum.photos/${randomNumber}00/${randomNumber}00"
        urlImage?.value = url
        Log.d("alexh", "Generated url: $url")
    }

}