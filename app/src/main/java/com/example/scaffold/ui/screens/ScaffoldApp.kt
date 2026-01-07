package com.example.scaffold.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            MainScreen(navController)
        }
        composable("info") {
            InfoScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }
    }
}

