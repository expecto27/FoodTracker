package com.example.foodtracker.data.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migration2 : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS eat_day (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "server_id INTEGER, " +
                "local_id INTEGER, " +
                "day INTEGER NOT NULL, " +
                "meal INTEGER NOT NULL)")
    }
}
object Migration3 : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE eat_day ADD COLUMN weight INTEGER NOT NULL DEFAULT 0")
    }
}

object Migrations4 : Migration(3, 4){
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS drink (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ml INTEGER NOT NULL," +
                "day INTEGER NOT NULL)")
    }
}
