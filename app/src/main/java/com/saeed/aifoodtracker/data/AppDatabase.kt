package com.saeed.aifoodtracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saeed.aifoodtracker.data.dao.FoodEntryDao
import com.saeed.aifoodtracker.data.dao.FoodCatalogDao
import com.saeed.aifoodtracker.data.entity.FoodEntry
import com.saeed.aifoodtracker.data.entity.FoodCatalog

@Database(
    entities = [FoodEntry::class, FoodCatalog::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodEntryDao(): FoodEntryDao
    abstract fun foodCatalogDao(): FoodCatalogDao
}

