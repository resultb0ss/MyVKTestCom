package com.example.myvktestcom.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myvktestcom.domain.models.VideoEntity
import com.example.myvktestcom.presentation.navigation.AppNavigation
import com.example.myvktestcom.ui.theme.MyVKTestComTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyVKTestComTheme {
               AppNavigation()
            }
        }
    }
}
