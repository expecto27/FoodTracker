package com.example.foodtracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodtracker.data.database.converters.DateConverter
import com.example.foodtracker.data.database.dao.EatDayDao
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.database.migrations.Migration2
import com.example.foodtracker.data.database.migrations.Migration3
import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.data.models.Product

@Database(entities = [Product::class, EatDay::class], version = 3, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ProductDao(): ProductDao
    abstract fun EatDayDao() : EatDayDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                )
                    .addMigrations(Migration2)
                    .addMigrations(Migration3).build()
                INSTANCE = instance
                instance
            }
        }
    }
}