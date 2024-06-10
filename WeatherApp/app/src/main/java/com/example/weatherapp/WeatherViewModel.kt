package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    private lateinit var averageTemperatureTextView: TextView
    private lateinit var weatherRecyclerView: RecyclerView
    private lateinit var weatherAdapter: Adapter
    private lateinit var clearDataButton: Button
    private lateinit var detailedViewButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get($WeatherViewModel::class.java)
        averageTemperatureTextView = findViewById(R.id.averageTemperatureTextView)
        weatherRecyclerView = findViewById(R.id.weatherRecyclerView)
        clearDataButton = findViewById(R.id.clearDataButton)
        detailedViewButton = findViewById(R.id.detailedViewButton)
        exitButton = findViewById(R.id.exitButton)

        weatherRecyclerView.layoutManager = LinearLayoutManager(this)
        weatherAdapter = Adapter()
        weatherRecyclerView.adapter = weatherAdapter

        viewModel.weeklyWeather.observe(this, { weeklyWeather ->
            weeklyWeather?.let {
                weatherAdapter.submitList(it.days)
                averageTemperatureTextView.text = "Average Temperature: ${viewModel.calculateAverageTemperature()}°C"
            }
        })

        clearDataButton.setOnClickListener {
            viewModel.ClearWeatherData()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivitiy::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}