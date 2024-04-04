package com.example.foodtracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao
}