package com.example.foodtracker.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodtracker.R
import com.example.foodtracker.databinding.ActivityMainBinding
import com.example.foodtracker.presentation.ui.fragments.drink.DrinkFragment
import com.example.foodtracker.presentation.ui.fragments.main.MainFragment
import com.example.foodtracker.presentation.ui.fragments.myproducts.MyProductFragment
import com.example.foodtracker.presentation.ui.fragments.stepcounter.StepCounterFragment
import com.example.foodtracker.presentation.ui.imtstat.ImtStatFragment
import com.example.foodtracker.presentation.ui.navigation.INavigationManager
import com.example.foodtracker.presentation.ui.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentChanger {

    private lateinit var binding: ActivityMainBinding
    private val navManager: INavigationManager = NavigationManager(supportFragmentManager)
    private var currentFragment: Fragment = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
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

                R.id.myProductFragment -> {
                    navManager.replace(
                        binding.mainFragment.id,
                        MyProductFragment.newInstance()
                    )
                    currentFragment = MyProductFragment.newInstance()
                    true
                }

                R.id.stepCountFragment -> {
                    navManager.replace(
                        binding.mainFragment.id,
                        StepCounterFragment.newInstance()
                    )
                    currentFragment = StepCounterFragment.newInstance()
                    true
                }
                R.id.waterFragment -> {
                    navManager.replace(
                        binding.mainFragment.id,
                        DrinkFragment.newInstance()
                    )
                    currentFragment = DrinkFragment.newInstance()
                    true
                }
                else -> {
                    navManager.delete(currentFragment)
                    false
                }
            }
        }
    }

    override fun backInBackStack() {
        navManager.backInBackStack()
    }

    override fun changeMainFragment(fragment: Fragment) {
        navManager.replaceToBackStack(
            binding.mainFragment.id,
            fragment
        )
    }

}