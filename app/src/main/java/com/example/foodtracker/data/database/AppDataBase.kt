package com.example.foodtracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.foodtracker.data.database.converters.DateConverter
import com.example.foodtracker.data.database.dao.EatDayDao
import com.example.foodtracker.data.database.dao.ProductDao
import com.example.foodtracker.data.models.EatDay
import com.example.foodtracker.data.models.Product

@Database(entities = [Product::class, EatDay::class], version = 2, exportSchema = false)
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
                ).addMigrations(MIGRATION_1_2).build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = object  : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE IF NOT EXISTS eat_day (" +
                        "id INTEGER PRIMARY KEY NOT NULL, " +
                        "server_id INTEGER, " +
                        "local_id INTEGER, " +
                        "day LONG, " +
                        "meal INTEGER)")
            }
        }
    }
}