package me.alexnaupay.jetpackexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagePhoto: ImageView = findViewById(R.id.imagePhoto)
        val imagePhoto2: ImageView = findViewById(R.id.imagePhoto2)
        val btnGetNewImage: Button = findViewById(R.id.btnGetNewImage)

        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val urlImage = model.callUrlImage()  // Get the MutableLiveData

        // Observe for changes
        urlImage?.observe(this, Observer {
            if (!it.isNullOrBlank()){
                Log.i("alexh", "It value: $it")
                Picasso.get().load(it).into(imagePhoto)
                Picasso.get().load(it).into(imagePhoto2)
            }else{
                Log.i("alexh", "It value is blank or null")
            }
        })

        // Call onclick actions
        btnGetNewImage.setOnClickListener {
            model.setRandomUrl()
            Log.i("alexh", "Clicked")
        }



    }
}