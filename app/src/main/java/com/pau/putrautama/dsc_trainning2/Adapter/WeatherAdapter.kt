package com.pau.putrautama.dsc_trainning2.Adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pau.putrautama.dsc_trainning2.Model.Weather_list
import com.pau.putrautama.dsc_trainning2.R
import com.squareup.picasso.Picasso

class WeatherAdapter(val weather_list:ArrayList<Weather_list>):RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //infalete to weather_list layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.weather_list,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        //get number of item in weather_list
        return weather_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Binding the value from weather_list
        holder.bindItems(weather_list[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //set weather_list to xml
        @SuppressLint("SetTextI18n")
        fun bindItems(data : Weather_list){
            val kota: TextView = itemView.findViewById(R.id.tv_name_kota)
            val temperatur: TextView = itemView.findViewById(R.id.tv_temperature)
            val icon: ImageView = itemView.findViewById(R.id.iv_icon)

            kota.text = data.nama_kota
            temperatur.text = data.temperature+"°"
            Picasso.get().load(data.weather_icon).into(icon)
        }
    }


}