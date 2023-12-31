package com.lecturecontrol.presentation.ui.screens.sponsors

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun SponsorsContent() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Patrocinadores em construção...",
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
    }
}
