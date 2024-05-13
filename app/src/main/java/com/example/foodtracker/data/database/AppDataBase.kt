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
                    .addMigrations(MIGRATION_1_2)
                    .addMigrations(MIGRATION_2_3).build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = object  : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE IF NOT EXISTS eat_day (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "server_id INTEGER, " +
                        "local_id INTEGER, " +
                        "day INTEGER NOT NULL, " +
                        "meal INTEGER NOT NULL)")
            }
        }
        private val MIGRATION_2_3 = object  : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE eat_day ADD COLUMN weight INTEGER NOT NULL DEFAULT 0")
            }
        }
    }
}