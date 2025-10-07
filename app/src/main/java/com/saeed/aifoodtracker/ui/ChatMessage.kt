package com.saeed.aifoodtracker.ui

data class ChatMessage(
    val sender: Sender,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

enum class Sender {
    USER, AI
}

