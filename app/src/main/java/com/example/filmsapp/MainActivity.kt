package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
    }
}