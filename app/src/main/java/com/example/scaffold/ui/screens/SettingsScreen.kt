package com.example.scaffold.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scaffold.ui.components.ScreenTopBar

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Settings", navController) }
    ) { innerPadding ->
        Text(
            text = "Settings Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}



