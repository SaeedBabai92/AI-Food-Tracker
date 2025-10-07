package com.saeed.aifoodtracker.data.dao

import androidx.room.*
import com.saeed.aifoodtracker.data.entity.FoodCatalog
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodCatalogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: FoodCatalog): Long

    @Update
    suspend fun update(food: FoodCatalog)

    @Delete
    suspend fun delete(food: FoodCatalog)

    @Query("SELECT * FROM food_catalog WHERE name LIKE :query OR synonyms LIKE :query ORDER BY name ASC")
    fun searchFoods(query: String): Flow<List<FoodCatalog>>

    @Query("SELECT * FROM food_catalog ORDER BY name ASC")
    fun getAllFoods(): Flow<List<FoodCatalog>>
}

