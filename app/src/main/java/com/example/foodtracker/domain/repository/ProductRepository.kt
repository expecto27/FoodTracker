package com.example.foodtracker.domain.repository

interface ProductRepository {
    fun save() : Boolean
    fun getAll()
}