package com.saeed.aifoodtracker.di

import android.content.Context
import androidx.room.Room
import com.saeed.aifoodtracker.data.AppDatabase
import com.saeed.aifoodtracker.data.dao.FoodCatalogDao
import com.saeed.aifoodtracker.data.dao.FoodEntryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "aifoodtracker.db"
        ).build()

    @Provides
    fun provideFoodEntryDao(db: AppDatabase): FoodEntryDao = db.foodEntryDao()

    @Provides
    fun provideFoodCatalogDao(db: AppDatabase): FoodCatalogDao = db.foodCatalogDao()
}
