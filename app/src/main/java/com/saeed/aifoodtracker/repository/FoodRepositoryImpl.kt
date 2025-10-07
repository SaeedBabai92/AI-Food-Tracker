package com.saeed.aifoodtracker.repository

import com.saeed.aifoodtracker.data.dao.FoodEntryDao
import com.saeed.aifoodtracker.data.dao.FoodCatalogDao
import com.saeed.aifoodtracker.data.entity.FoodEntry
import com.saeed.aifoodtracker.data.entity.FoodCatalog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepositoryImpl @Inject constructor(
    private val foodEntryDao: FoodEntryDao,
    private val foodCatalogDao: FoodCatalogDao
) : FoodRepository {
    // FoodEntry
    override suspend fun insertFoodEntry(entry: FoodEntry) = foodEntryDao.insert(entry)
    override suspend fun updateFoodEntry(entry: FoodEntry) = foodEntryDao.update(entry)
    override suspend fun deleteFoodEntry(entry: FoodEntry) = foodEntryDao.delete(entry)
    override fun getEntriesByDate(date: Long): Flow<List<FoodEntry>> = foodEntryDao.getEntriesByDate(date)
    override fun getAllEntries(): Flow<List<FoodEntry>> = foodEntryDao.getAllEntries()

    // FoodCatalog
    override suspend fun insertFoodCatalog(food: FoodCatalog) = foodCatalogDao.insert(food)
    override suspend fun updateFoodCatalog(food: FoodCatalog) = foodCatalogDao.update(food)
    override suspend fun deleteFoodCatalog(food: FoodCatalog) = foodCatalogDao.delete(food)
    override fun searchFoods(query: String): Flow<List<FoodCatalog>> = foodCatalogDao.searchFoods("%$query%")
    override fun getAllFoods(): Flow<List<FoodCatalog>> = foodCatalogDao.getAllFoods()
}
