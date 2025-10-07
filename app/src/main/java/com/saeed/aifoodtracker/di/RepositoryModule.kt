package com.saeed.aifoodtracker.di

import com.saeed.aifoodtracker.data.dao.FoodEntryDao
import com.saeed.aifoodtracker.data.dao.FoodCatalogDao
import com.saeed.aifoodtracker.repository.FoodRepository
import com.saeed.aifoodtracker.repository.FoodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindFoodRepository(
        impl: FoodRepositoryImpl
    ): FoodRepository
}

