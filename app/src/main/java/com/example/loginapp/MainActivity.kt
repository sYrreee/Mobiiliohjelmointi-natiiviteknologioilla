package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import com.example.loginapp.ui.theme.LoginAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginAppTheme {

                // Tämä muuttuja vaihtaa näkymän submit-napin jälkeen
                var showLogin by remember { mutableStateOf(true) }

                Surface(color = MaterialTheme.colorScheme.background) {
                    if (showLogin) {
                        LoginScreen(
                            onSubmit = {
                                showLogin = false
                            }
                        )
                    } else {
                        // Tämä on seuraava näkymä (vielä tyhjä)
                        PhyphoxScreen()
                    }
                }
            }
        }
    }
}