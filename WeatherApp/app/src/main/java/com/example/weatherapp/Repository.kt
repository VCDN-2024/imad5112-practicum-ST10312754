package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WeatherRepository {
    // Simulate network call or database fetch
    fun getWeeklyWeather(): WeeklyWeather {
        // Dummy data for demonstration
        return WeeklyWeather(
            listOf(
                Weather("Monday", 20.5, 25.0, 15.0, "Sunny", 60, 5.0),
                Weather("Tuesday", 18.0, 22.0, 16.0, "Cloudy", 65, 4.0),
                Weather("Wednesday", 19.0, 24.0, 14.0, "Rainy", 70, 3.5),
                Weather("Thursday", 22.0, 28.0, 18.0, "Sunny", 55, 6.0),
                Weather("Friday", 21.0, 26.0, 17.0, "Windy", 50, 7.0),
                Weather("Saturday", 23.0, 30.0, 20.0, "Sunny", 40, 8.0),
                Weather("Sunday", 20.0, 23.0, 16.0, "Cloudy", 60, 5.5)
            )
        )
    }
}