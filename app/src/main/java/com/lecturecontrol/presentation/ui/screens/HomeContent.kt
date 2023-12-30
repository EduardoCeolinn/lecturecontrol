package com.lecturecontrol.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lecturecontrol.presentation.ui.components.LectureItem
import com.lecturecontrol.presentation.ui.components.LectureSearchBar
import com.lecturecontrol.presentation.viewmodel.LectureListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeContent(navController: NavController) {
    val lectureListViewModel: LectureListViewModel = getViewModel()
    val lecturesState by lectureListViewModel.lectures.observeAsState(emptyList())
    var filteredLectures by remember { mutableStateOf(lecturesState) }
    LaunchedEffect(lecturesState) {
        filteredLectures = lecturesState
    }

    Column {
        LectureSearchBar { searchTerm ->
            filteredLectures = if (searchTerm.isBlank()) {
                lecturesState
            } else {
                lecturesState.filter { it.subject.contains(searchTerm, ignoreCase = true) }
            }
        }

        LazyColumn(contentPadding = PaddingValues(bottom = 60.dp))
        {
            itemsIndexed(filteredLectures) { index, lecture ->
                LectureItem(
                    lecture = lecture,
                    context = LocalContext.current,
                    navController = navController,
                    isFirstItem = index == 0,
                    onFavoriteClick = { lectureListViewModel.favoriteLecture(lecture) }
                )
            }
        }
    }
}
