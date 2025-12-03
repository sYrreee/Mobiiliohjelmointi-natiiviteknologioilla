package com.example.calorieapp

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.RadioButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem

@Composable
fun CalorieApp(modifier: Modifier = Modifier) {

    var weightInput by remember { mutableStateOf("") }
    var weight = weightInput.toFloatOrNull() ?: 0f

    var isMale by remember { mutableStateOf(true) }

    var intensity by remember { mutableStateOf(1.1f) }   // Default = Light 1.1

    var result by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Heading("Calories")

        WeightField(
            weightInput = weightInput,
            onValueChange = { weightInput = it }
        )

        GenderChoices(
            male = isMale,
            setGender = { isMale = it }
        )

        IntensityList(
            selectedIntensity = intensity,
            onClick = { intensity = it }
        )

        Text(
            text = result.toString(),
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )

        Calculation(
            male = isMale,
            weight = weight,
            intensity = intensity,
            setResult = { result = it }
        )
    }
}

@Composable
fun Heading(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
    )
}


@Composable
fun WeightField(weightInput: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Enter weight (kg)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun GenderChoices(male: Boolean, setGender: (Boolean) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = male,
                onClick = { setGender(true) }
            )
            Text("Male")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !male,
                onClick = { setGender(false) }
            )
            Text("Female")
        }
    }
}


@Composable
fun IntensityList(selectedIntensity: Float, onClick: (Float) -> Unit) {

    var expanded by remember { mutableStateOf(false) }

    val intensities = listOf(
        "Light 1.1" to 1.1f,
        "Usual 1.2" to 1.2f,
        "Moderate 1.4" to 1.4f,
        "Hard 1.7" to 1.7f,
        "Very hard 2.2" to 2.2f
    )

    val selectedLabel = intensities.first { it.second == selectedIntensity }.first

    Column {
        OutlinedTextField(
            value = selectedLabel,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            label = { Text("Select activity intensity") },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            intensities.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item.first) },
                    onClick = {
                        onClick(item.second)
                        expanded = false
                    }
                )
            }
        }
    }
}


@Composable
fun Calculation(
    male: Boolean,
    weight: Float,
    intensity: Float,
    setResult: (Float) -> Unit
) {
    Button(
        onClick = {
            val base = if (male) 879f else 795f
            val result = (base + (10.2f * weight)) * intensity
            setResult(result)
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Calculate")
    }
}



