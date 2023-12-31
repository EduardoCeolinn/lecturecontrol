package com.lecturecontrol.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.domain.usecase.GetSpeakerUseCase
import kotlinx.coroutines.launch

class SpeakerViewModel(private val getSpeakersUseCase: GetSpeakerUseCase) : ViewModel() {
    private val _speaker = MutableLiveData<Speaker>()
    val speaker: MutableLiveData<Speaker> = _speaker

    private val _speakers = MutableLiveData<List<Speaker>>()
    val speakers: MutableLiveData<List<Speaker>> = _speakers

    fun getSpeakerById(speakerId: String) {
        viewModelScope.launch {
            try {
                val speaker = getSpeakersUseCase.getSpeakerById(speakerId)
                _speaker.value = speaker
            } catch (_: Exception) {
            }
        }
    }

    fun getAllSpeakers() {
        viewModelScope.launch {
            try {
                val allSpeakers = getSpeakersUseCase.getAllSpeakers()
                _speakers.value = allSpeakers
            } catch (_: Exception) {
            }
        }
    }
}
