package com.example.customcompose.utils

import androidx.compose.ui.graphics.Color

object ConverterUtils{

    fun parseStringToColor(hex: String): Color {
        return try {

            val formatHex = if (hex.startsWith("#")) hex.substring(1) else hex
            val argb = if (formatHex.length == 6) "FF$formatHex" else formatHex

            Color(android.graphics.Color.parseColor("#$argb"))
        } catch (e: IllegalArgumentException) {
            Color(0xFF000000)
        }
    }
}