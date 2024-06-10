package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExit: Button = findViewById(R.id.btnExit)
        val btnMenu: Button = findViewById(R.id.btnMenu)
        btnExit.setOnClickListener {
            finishAffinity() // This closes the app

        }
        btnMenu.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}