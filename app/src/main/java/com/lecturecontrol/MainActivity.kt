package com.lecturecontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.lecturecontrol.di.lectureModule
import com.lecturecontrol.di.speakerModule
import com.lecturecontrol.presentation.ui.screens.home.HomeScreen
import com.lecturecontrol.presentation.ui.screens.splash.SplashScreen
import com.lecturecontrol.presentation.ui.screens.splash.SplashScreenActions
import com.lecturecontrol.presentation.ui.theme.LectureControlTheme
import com.lecturecontrol.presentation.ui.theme.MainPurple
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainActivity)
            modules(listOf(lectureModule, speakerModule))
        }

        setContent {
            LectureControlTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MainPurple
                ) {
                    SplashScreen(
                        actions = SplashScreenActions(onSplashEnd = { navigateToHomeScreen() })
                    )
                }
            }
        }
    }

    private fun navigateToHomeScreen() {
        setContent {
            HomeScreen()
        }
    }
}