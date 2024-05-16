package com.example.foodtracker.domain.usecase

import com.example.foodtracker.domain.models.UserData
import com.example.foodtracker.domain.repository.UserDataRepository

class SaveUserData (private val userDataRepository: UserDataRepository) {
    fun execute(userData: UserData): Boolean{
        return userDataRepository.saveUserData(userData)
    }

}