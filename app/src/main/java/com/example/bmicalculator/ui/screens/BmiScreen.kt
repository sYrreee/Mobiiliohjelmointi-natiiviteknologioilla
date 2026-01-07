package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmicalculator.ui.viewmodel.BmiViewModel

@Composable
fun BmiScreen(
    modifier: Modifier = Modifier,
    viewModel: BmiViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bmi calculator",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.height.value,
            onValueChange = viewModel::onHeightChange,
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.weight.value,
            onValueChange = viewModel::onWeightChange,
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        viewModel.bmi.value?.let {
            Text(
                text = "Your bmi is $it",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


