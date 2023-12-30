package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lecturecontrol.R
import com.lecturecontrol.presentation.ui.navigation.Routes

@Composable
fun BottomBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        modifier = Modifier
            .wrapContentHeight()
            .padding(20.dp, 6.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_guide),
                    contentDescription = "Mapa",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    text = "Mapa",
                    color = Color.White,
                    fontSize = 14.sp,
                )
            },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_calendar),
                    contentDescription = "Agenda",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    text = "Agenda",
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_home),
                    contentDescription = "Home",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    text = "Home",
                    color = Color.White,
                    fontSize = 14.sp,
                )
            },
            selected = false,
            onClick = {
                if (currentRoute != Routes.Home.route) {
                    navController.navigate(Routes.Home.route)
                }
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_explorer),
                    contentDescription = "Explorar",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    text = "Explorar",
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_chat),
                    contentDescription = "Chat",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    text = "Chat",
                    color = Color.White,
                    fontSize = 14.sp,
                )
            },
            selected = false,
            onClick = { }
        )
    }
}

@Composable
@Preview
fun BottomBarPreview() {
    val navController = rememberNavController()
    BottomBar(navController = navController)
}