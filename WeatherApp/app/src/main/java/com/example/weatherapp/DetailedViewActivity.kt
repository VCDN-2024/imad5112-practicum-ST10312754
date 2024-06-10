package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity() {

    private lateinit var detailedWeatherAdapter: WeatherAdapter
    private lateinit var weatherDataList: MutableList<WeatherData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        weatherDataList = intent.getParcelableArrayListExtra("weatherDataList") ?: mutableListOf()
        detailedWeatherAdapter = WeatherAdapter(weatherDataList)

        recyclerViewDetails.layoutManager = LinearLayoutManager(this)
        recyclerViewDetails.adapter = detailedWeatherAdapter

        btnBack.setOnClickListener {
            finish()
        }
    }
}