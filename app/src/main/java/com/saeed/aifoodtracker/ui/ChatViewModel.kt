package com.saeed.aifoodtracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.saeed.aifoodtracker.repository.FoodRepository

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val foodRepository: FoodRepository // Injecting FoodRepository
) : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    fun sendMessage(userMessage: String) {
        // Lisää käyttäjän viesti keskusteluun
        val updated = _messages.value + ChatMessage(Sender.USER, userMessage)
        _messages.value = updated
        // Simuloi AI-vastaus (tässä kohtaa oikea AI-kutsu)
        viewModelScope.launch {
            val aiResponse = handleUserMessage(userMessage)
            _messages.value = _messages.value + ChatMessage(Sender.AI, aiResponse)
        }
    }

    private suspend fun handleUserMessage(message: String): String {
        // TODO: Tähän oikea AI-logiikka ja FoodViewModelin käyttö
        // Esimerkki: jos käyttäjä pyytää makrot, palautetaan makroyhteenveto
        if (message.contains("makrot", ignoreCase = true)) {
            val entries = foodRepository.getAllEntries().first() // Collect the Flow to get the List
            val protein = entries.sumOf { it.protein.toDouble() }
            val carbs = entries.sumOf { it.carbs.toDouble() }
            val fat = entries.sumOf { it.fat.toDouble() }
            val kcal = entries.sumOf { it.kcal }
            return "Tänään syöty: ${protein.toInt()} g proteiinia, ${carbs.toInt()} g hiilaria, ${fat.toInt()} g rasvaa, $kcal kcal."
        }
        return "(AI-vastaus tähän: $message)"
    }
}
