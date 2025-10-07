package com.saeed.aifoodtracker.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_catalog")
data class FoodCatalog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val proteinPer100g: Float,
    val carbsPer100g: Float,
    val fatPer100g: Float,
    val kcalPer100g: Int,
    val defaultUnit: String,      // esim. "g", "kpl"
    val gramsPerPiece: Float?,    // jos yksikkö on "kpl"
    val synonyms: String          // pilkulla eroteltu lista synonyymeistä
)

