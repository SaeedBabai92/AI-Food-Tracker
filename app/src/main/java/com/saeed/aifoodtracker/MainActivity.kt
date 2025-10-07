package com.saeed.aifoodtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.saeed.aifoodtracker.ui.ChatScreen
import com.saeed.aifoodtracker.ui.theme.AIFoodTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AIFoodTrackerTheme {
                ChatScreen()
            }
        }
    }
}
