package com.example.foodtracker.presentation.ui.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NavigationManager(var fragmentManager: FragmentManager) : INavigationManager {

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

    override fun backInBackStack() {
        fragmentManager.popBackStack()
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