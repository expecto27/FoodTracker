package com.example.foodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodtracker.R
import com.example.foodtracker.databinding.ActivityMainBinding
import com.example.foodtracker.presentation.ui.imtstat.ImtStatFragment
import com.example.foodtracker.presentation.ui.main.MainFragment
import com.example.foodtracker.presentation.ui.navigation.INavigationManager
import com.example.foodtracker.presentation.ui.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var currentFragment: Fragment = MainFragment.newInstance()
        val navManager : INavigationManager = NavigationManager(supportFragmentManager)

        binding.bottomNav.setOnItemSelectedListener {item ->

            when(item.itemId){
                R.id.mainFragment -> {
                    navManager.replace(
                        binding.mainFragment.id,
                        MainFragment.newInstance()
                    )
                    currentFragment = MainFragment.newInstance()
                    true // select light
                }
                R.id.imtFragment -> {
                    navManager.replace(
                        binding.mainFragment.id,
                        ImtStatFragment.newInstance()
                    )
                    currentFragment = ImtStatFragment.newInstance()
                    true
                }
                else -> {
                    navManager.delete(currentFragment)
                    false
                }
            }
        }
    }
}