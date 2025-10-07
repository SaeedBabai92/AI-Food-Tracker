package com.saeed.aifoodtracker.repository

import com.saeed.aifoodtracker.data.entity.FoodEntry
import com.saeed.aifoodtracker.data.entity.FoodCatalog
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    // FoodEntry
    suspend fun insertFoodEntry(entry: FoodEntry): Long
    suspend fun updateFoodEntry(entry: FoodEntry)
    suspend fun deleteFoodEntry(entry: FoodEntry)
    fun getEntriesByDate(date: Long): Flow<List<FoodEntry>>
    fun getAllEntries(): Flow<List<FoodEntry>>

    // FoodCatalog
    suspend fun insertFoodCatalog(food: FoodCatalog): Long
    suspend fun updateFoodCatalog(food: FoodCatalog)
    suspend fun deleteFoodCatalog(food: FoodCatalog)
    fun searchFoods(query: String): Flow<List<FoodCatalog>>
    fun getAllFoods(): Flow<List<FoodCatalog>>
}

