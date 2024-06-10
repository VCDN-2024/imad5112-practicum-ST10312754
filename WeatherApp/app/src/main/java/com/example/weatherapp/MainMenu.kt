package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val weatherDataList = mutableListOf<EditText>()
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherAdapter = WeatherAdapter(weatherDataList)
        View.layout = LinearLayoutManager(this)
        View.adapter = weatherAdapter

        btnAddData.setOnClickListener {
            addWeatherData()
        }

        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            ["2:37 AM"]
            intent.putParcelableArrayListExtra("weatherDataList", ArrayList(weatherDataList))
            startActivity(intent)
        }

        btnClearData.setOnClickListener {
            clearData()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    private fun addWeatherData() {
        val day = edtDay.text.toString()
        val minTemp = edtMinTemperature.text.toString().toDoubleOrNull()
        val maxTemp = edtMaxTemperature.text.toString().toDoubleOrNull()
        val condition = edtWeatherConditions.text.toString()

        if (day.isNotEmpty() && minTemp != null && maxTemp != null && condition.isNotEmpty()) {
            val weatherData = WeatherData(day, minTemp, maxTemp, condition)
            weatherDataList.add(weatherData)
            weatherAdapter.notifyDataSetChanged()
            calculateAndDisplayAverageTemperature()
            clearInputFields()
        } else {
            // Show error message
        }
    }

    private fun calculateAndDisplayAverageTemperature() {
        if (weatherDataList.isEmpty()) {
            tvAverageTemperature.text = "Average Temperature: N/A"
            return
        }

        val totalTemp = weatherDataList.sumByDouble { it.maxTemperature }
        val averageTemp = totalTemp / weatherDataList.size
        tvAverageTemperature.text = "Average Temperature: $averageTemp°C"
    }

    private fun clearInputFields() {
        edtDay.text.clear()
        edtMinTemperature.text.clear()
        edtMaxTemperature.text.clear()
        edtWeatherCondition.text.clear()
    }

    private fun clearData() {
        weatherDataList.clear()
        weatherAdapter.notifyDataSetChanged()
        tvAverageTemperature.text = "Average Temperature: N/A"
    }
}
