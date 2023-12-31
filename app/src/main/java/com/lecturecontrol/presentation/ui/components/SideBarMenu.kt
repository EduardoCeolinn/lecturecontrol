package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lecturecontrol.R
import com.lecturecontrol.presentation.navigation.Routes
import com.lecturecontrol.presentation.ui.theme.MainPurple
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SideBarMenu(
    navController: NavController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {

    val menuItems = listOf(
        MenuItem("Guia do Visitante", R.drawable.ic_guide, Routes.VisitorGuide.route),
        MenuItem("Mapa Interativo", R.drawable.ic_local, Routes.InteractiveMap.route),
        MenuItem("Sala de Reunião", R.drawable.ic_meeting, Routes.MeetingRoom.route),
        MenuItem("Perfil", R.drawable.ic_profile, Routes.Profile.route),
        MenuItem("Patrocinadores", R.drawable.ic_sponsors, Routes.Sponsors.route),
        MenuItem("Configurações", R.drawable.ic_settings, Routes.Settings.route)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainPurple)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "Menu",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .padding(30.dp)
                    .clickable {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    },
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "Fechar Menu",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(48.dp))

        menuItems.forEach { menuItem ->
            ListItem(
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                    navController.navigate(menuItem.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = menuItem.iconResId),
                        contentDescription = menuItem.title,
                        tint = Color.White
                    )
                },
                text = {
                    Text(
                        text = menuItem.title,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // close app
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_leave),
                contentDescription = "Sair",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "Sair",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

data class MenuItem(val title: String, val iconResId: Int, val route: String)
