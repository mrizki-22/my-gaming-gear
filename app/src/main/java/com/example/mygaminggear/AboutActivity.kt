package com.example.mygaminggear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About me"

        val imgProfile = findViewById<ImageView>(R.id.img_profile)
        imgProfile.setImageResource(R.drawable.foto)
    }
}