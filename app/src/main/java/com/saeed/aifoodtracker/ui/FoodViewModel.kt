package com.saeed.aifoodtracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saeed.aifoodtracker.data.entity.FoodEntry
import com.saeed.aifoodtracker.data.entity.FoodCatalog
import com.saeed.aifoodtracker.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {
    val allEntries: StateFlow<List<FoodEntry>> = repository.getAllEntries()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allFoods: StateFlow<List<FoodCatalog>> = repository.getAllFoods()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addFoodEntry(entry: FoodEntry) {
        viewModelScope.launch { repository.insertFoodEntry(entry) }
    }

    fun deleteFoodEntry(entry: FoodEntry) {
        viewModelScope.launch { repository.deleteFoodEntry(entry) }
    }

    fun searchFoods(query: String): StateFlow<List<FoodCatalog>> =
        repository.searchFoods(query)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}

