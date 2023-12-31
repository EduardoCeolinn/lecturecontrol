package com.lecturecontrol.presentation.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lecturecontrol.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(actions: SplashScreenActions) {
    val scale = remember { Animatable(1f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 2.5f,
            animationSpec = tween(durationMillis = 2000)
        )
        actions.onSplashEnd()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo_lab2dev),
            contentDescription = stringResource(R.string.logo_content_description),
            modifier = Modifier.size(100.dp * scale.value)
        )
    }
}


data class SplashScreenActions(
    val onSplashEnd: () -> Unit
)

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(SplashScreenActions {})
}
