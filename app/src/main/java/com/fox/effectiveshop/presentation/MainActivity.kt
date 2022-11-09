package com.fox.effectiveshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.effectiveshop.R
import com.fox.effectiveshop.databinding.ActivityMainBinding
import com.fox.effectiveshop.presentation.screens.MainScreenFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}