package com.example.scaffold.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scaffold.ui.components.MainTopAppBar

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { MainTopAppBar("My app", navController) }
    ) { innerPadding ->
        Text(
            text = "Home Screen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
