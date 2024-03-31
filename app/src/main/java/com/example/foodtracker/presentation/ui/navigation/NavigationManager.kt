package com.example.foodtracker.presentation.ui.navigation

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace

class NavigationManager(var fragmentManager: FragmentManager) : INavigationManager{

    override fun add(container: Int, fragment: Fragment){
        fragmentManager
            .beginTransaction()
            .add(container, fragment)
            .commit()
    }

    override fun replaceToBackStack(container: Int, fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun replace(container: Int, fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .commit()
    }

    override fun delete(fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .remove(fragment)
            .commit()
    }
}