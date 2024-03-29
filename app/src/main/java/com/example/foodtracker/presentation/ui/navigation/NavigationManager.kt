package com.example.foodtracker.presentation.ui.navigation

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NavigationManager(var fragmentManager: FragmentManager) : INavigationManager{

    override fun add(container: Int, fragment: Fragment){
        fragmentManager
            .beginTransaction()
            .add(container, fragment)
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