package com.example.mygaminggear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvGear: RecyclerView
    private val list = ArrayList<Gear>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Logitech Gaming Gear"

        rvGear = findViewById(R.id.rv_gear)
        rvGear.setHasFixedSize(true)

        list.addAll(listGear)
        showRecyclerList()
    }

    private val listGear: ArrayList<Gear>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listGear = ArrayList<Gear>()
            for (i in dataName.indices) {
                val gear = Gear(dataName[i], dataDescription[i], dataPhoto[i])
                listGear.add(gear)
            }
            return listGear
        }

    private fun showRecyclerList() {
        rvGear.layoutManager = LinearLayoutManager(this)
        var listGearAdapter = ListGearAdapter(list)
        rvGear.adapter = listGearAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                // move to about activity
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}