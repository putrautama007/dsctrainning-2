package com.pau.putrautama.dsc_trainning2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.pau.putrautama.dsc_trainning2.Adapter.WeatherAdapter
import com.pau.putrautama.dsc_trainning2.Model.Weather_list
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set Action Bar
        setSupportActionBar(toolbar)

        //set Temperature text
        val tv_temperature =  findViewById<TextView>(R.id.text_temperature)
        tv_temperature.text = "13°"

        //Initialization Recyclerview
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false)

        //Initialization weather_list object
        val mWeather_list = ArrayList<Weather_list>()

        mWeather_list.add(Weather_list("London, United Kingdom", "14", R.drawable.ic_clouds))
        mWeather_list.add(Weather_list("Stockholm, Sweden", "8", R.drawable.ic_sun))
        mWeather_list.add(Weather_list("San Fransisco, United States", "19", R.drawable.ic_rainy))

        //set weather_list to recyclerview
        val mAdapter = WeatherAdapter(mWeather_list)
        recyclerView.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Inflate menu item
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //handle action bar when it's click
        when(item?.itemId){
            R.id.action_settings ->{
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
