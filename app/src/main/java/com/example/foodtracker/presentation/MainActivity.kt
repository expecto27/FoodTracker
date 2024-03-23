package com.example.foodtracker.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodtracker.R
import com.example.foodtracker.presentation.ui.imtstat.ImtStatFragment
import com.example.foodtracker.presentation.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}