package com.example.bmicalculator.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.round

class BmiViewModel : ViewModel() {

    var height = mutableStateOf("")
        private set

    var weight = mutableStateOf("")
        private set

    var bmi = mutableStateOf<Double?>(null)
        private set

    fun onHeightChange(value: String) {
        height.value = value
        calculateBmi()
    }

    fun onWeightChange(value: String) {
        weight.value = value
        calculateBmi()
    }

    private fun calculateBmi() {
        val h = height.value.toDoubleOrNull()
        val w = weight.value.toDoubleOrNull()

        if (h != null && w != null && h > 0) {
            val result = w / (h * h)
            bmi.value = kotlin.math.round(result * 10) / 10
        } else {
            bmi.value = null
        }
    }
}


