package com.ryuken.mugen.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Scaffold() {
        Column(modifier = Modifier.padding(it)
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                colorStops = arrayOf(
                    0.0f to Color(0xFF001a1a),
                    0.5f to Color(0xFF0a0030),
                    1.0f to Color(0xFF1a0020)
                )
            ))) { }
    }
}