package com.lecturecontrol.presentation.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lecturecontrol.presentation.ui.components.BottomBar
import com.lecturecontrol.presentation.ui.components.TopBar
import com.lecturecontrol.presentation.navigation.Routes
import com.lecturecontrol.presentation.ui.components.SideBarMenu
import com.lecturecontrol.presentation.ui.screens.interactivemap.InteractiveMapContent
import com.lecturecontrol.presentation.ui.screens.meetingroom.MeetingRoomContent
import com.lecturecontrol.presentation.ui.screens.profile.ProfileContent
import com.lecturecontrol.presentation.ui.screens.settings.SettingsContent
import com.lecturecontrol.presentation.ui.screens.speaker.SpeakerDetailsContent
import com.lecturecontrol.presentation.ui.screens.sponsors.SponsorsContent
import com.lecturecontrol.presentation.ui.screens.visitorguide.VisitorGuideContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val topBarTitle = remember { mutableStateOf("Palestras") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(navController, scaffoldState, coroutineScope, topBarTitle) },
        bottomBar = { BottomBar(navController) },
        drawerContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                SideBarMenu(navController, scaffoldState, coroutineScope)
            }
        }) {
        NavHost(navController = navController, startDestination = Routes.Home.route) {
            composable(route = Routes.Home.route) { HomeContent(navController) }
            composable(route = Routes.VisitorGuide.route) { VisitorGuideContent() }
            composable(route = Routes.InteractiveMap.route) { InteractiveMapContent() }
            composable(route = Routes.MeetingRoom.route) { MeetingRoomContent() }
            composable(route = Routes.Profile.route) { ProfileContent() }
            composable(route = Routes.Sponsors.route) { SponsorsContent() }
            composable(route = Routes.Settings.route) { SettingsContent() }
            composable(
                route = Routes.SpeakerDetails.route,
                arguments = listOf(navArgument("speakerId") { type = NavType.StringType })
            ) { backStackEntry ->
                val speakerId = backStackEntry.arguments?.getString("speakerId") ?: ""
                SpeakerDetailsContent(speakerId, topBarTitle)
            }
        }
    }
}