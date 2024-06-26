package com.example.foodtracker.presentation.ui.navigation

import androidx.fragment.app.Fragment

interface INavigationManager {
    fun add(container: Int, fragment: Fragment)
    fun replace(container: Int, fragment: Fragment)
    fun replaceToBackStack(container: Int, fragment: Fragment)
    fun backInBackStack()
    fun delete(fragment: Fragment)
}