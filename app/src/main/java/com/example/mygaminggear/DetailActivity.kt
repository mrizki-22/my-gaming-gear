package com.example.mygaminggear

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Item Detail"

        val dataGear = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Gear>("key_gear", Gear::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Gear>("key_gear")
        }

        val tvDetailName: TextView = findViewById(R.id.tvDetailName)
        val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)
        val ivDetailPhoto: ImageView = findViewById(R.id.ivDetailPhoto)

        if (dataGear != null) {
            tvDetailName.text = dataGear.name
            tvDetailDescription.text = dataGear.description
            //load image with glide
            Glide.with(this)
                .load(dataGear.photo)
                .into(ivDetailPhoto)
        }

        val buyBtn: Button = findViewById(R.id.action_buy)
        val shareBtn: Button = findViewById(R.id.action_share)
        buyBtn.setOnClickListener{
            var url = "https://www.tokopedia.com/search?st=product&q=${dataGear?.name}"
            val buyIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(buyIntent)
        }

        shareBtn.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            var gearName = dataGear?.name?.replace(" ", "%20")
            var url = "https://www.tokopedia.com/search?st=product&q=${gearName}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, check this amazing gear! ${dataGear?.name}, you can buy it on Tokopedia! Here's the link: $url")
            shareIntent.type = "text/plain"
            startActivity(shareIntent)
        }
    }

}