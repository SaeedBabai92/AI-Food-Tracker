package com.saeed.aifoodtracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ChatScreen(
    chatViewModel: ChatViewModel = hiltViewModel()
) {
    val messages by chatViewModel.messages.collectAsState()
    var input by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            reverseLayout = true
        ) {
            items(messages.size) { idx ->
                val msg = messages[messages.size - 1 - idx]
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (msg.sender == Sender.USER) Arrangement.End else Arrangement.Start
                ) {
                    Text(
                        text = "${if (msg.sender == Sender.USER) "Sinä" else "AI"}: ${msg.content}",
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.weight(1f).padding(8.dp)
            )
            Button(onClick = {
                if (input.isNotBlank()) {
                    chatViewModel.sendMessage(input)
                    input = ""
                }
            }) {
                Text("Lähetä")
            }
        }
    }
}

