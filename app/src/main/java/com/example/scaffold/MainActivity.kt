package com.example.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scaffold.ui.screens.ScaffoldApp
import com.example.scaffold.ui.theme.ScaffoldAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldAppTheme {
                ScaffoldApp()
            }
        }
    }
}


