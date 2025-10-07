package com.saeed.aifoodtracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_entries")
data class FoodEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val amount: Float, // määrä (esim. grammaa, kappaletta)
    val unit: String,  // yksikkö (esim. g, kpl)
    val prep: String?, // valmistustapa (esim. "keitetty", "paistettu")
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val kcal: Int,
    val date: Long // aikaleima (esim. System.currentTimeMillis())
)

