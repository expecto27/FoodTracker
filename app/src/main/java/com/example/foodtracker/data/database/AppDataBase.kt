package com.example.foodtracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}