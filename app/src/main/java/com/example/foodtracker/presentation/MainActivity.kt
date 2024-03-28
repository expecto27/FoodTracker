package com.example.foodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodtracker.R
import com.example.foodtracker.databinding.ActivityMainBinding
import com.example.foodtracker.presentation.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.container, MainFragment.newInstance())
//            .commit()
    }
}