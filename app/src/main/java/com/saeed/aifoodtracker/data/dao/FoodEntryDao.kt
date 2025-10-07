package com.saeed.aifoodtracker.data.dao

import androidx.room.*
import com.saeed.aifoodtracker.data.entity.FoodEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: FoodEntry): Long

    @Update
    suspend fun update(entry: FoodEntry)

    @Delete
    suspend fun delete(entry: FoodEntry)

    @Query("SELECT * FROM food_entries WHERE date = :date ORDER BY id DESC")
    fun getEntriesByDate(date: Long): Flow<List<FoodEntry>>

    @Query("SELECT * FROM food_entries ORDER BY date DESC, id DESC")
    fun getAllEntries(): Flow<List<FoodEntry>>
}

