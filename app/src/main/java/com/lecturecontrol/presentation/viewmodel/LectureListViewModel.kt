package com.lecturecontrol.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lecturecontrol.domain.model.Lecture
import com.lecturecontrol.domain.usecase.GetLecturesUseCase
import kotlinx.coroutines.launch

class LectureListViewModel(private val getLecturesUseCase: GetLecturesUseCase) : ViewModel() {
    private val _lectures = MutableLiveData<List<Lecture>>()
    val lectures: LiveData<List<Lecture>> = _lectures

    init {
        loadLectures()
    }

    private fun loadLectures() {
        viewModelScope.launch {
            try {
                val lecturesList = getLecturesUseCase()
                val sortedList = lecturesList.sortedByDescending { it.isFavorite }
                _lectures.value = sortedList
            } catch (e: Exception) {
                // TODO
            }
        }
    }

    fun favoriteLecture(lectureToToggle: Lecture) {
        viewModelScope.launch {
            val updatedList = _lectures.value?.map { lecture ->
                if (lecture.id == lectureToToggle.id) {
                    lecture.copy(isFavorite = !lecture.isFavorite)
                } else {
                    lecture
                }
            }
            val sortedList = updatedList?.sortedByDescending { it.isFavorite }
            _lectures.value = sortedList ?: emptyList()
        }
    }
}
