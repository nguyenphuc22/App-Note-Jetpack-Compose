package com.phucvr.appnotejetpackcompose.util

import androidx.compose.ui.graphics.Color

fun Color.Companion.hexToColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}