package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lecturecontrol.R
import com.lecturecontrol.presentation.ui.navigation.Routes
import com.lecturecontrol.presentation.ui.theme.MainPurple
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    navController: NavController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    topBarTitle: MutableState<String>
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val title = when (currentRoute) {
        Routes.Home.route -> "Palestras"
        Routes.VisitorGuide.route -> "Guia do Visitante"
        Routes.InteractiveMap.route -> "Mapa Interativo"
        Routes.MeetingRoom.route -> "Sala de Reunião"
        Routes.Profile.route -> "Perfil"
        Routes.Sponsors.route -> "Patrocinadores"
        Routes.Settings.route -> "Configurações"
        Routes.SpeakerDetails.route -> topBarTitle.value
        else -> ""
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back"
                    )
                }
            }
        } else null,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = MainPurple
                )
            }
        }
    )
}
