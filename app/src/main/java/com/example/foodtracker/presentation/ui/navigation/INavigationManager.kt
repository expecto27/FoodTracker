package com.example.foodtracker.presentation.ui.navigation

import android.view.View
import androidx.fragment.app.Fragment

interface INavigationManager {
    fun add(container: Int, fragment: Fragment)
    fun replace(container: Int, fragment: Fragment)
    fun delete(fragment: Fragment)
}