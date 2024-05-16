package com.example.foodtracker.domain.repository

import com.example.foodtracker.domain.models.UserData

interface UserDataRepository {
    fun saveUserData(userData: UserData) : Boolean
    fun getUserData(): UserData
}