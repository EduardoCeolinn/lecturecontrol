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

    fun getSpeakerById(speakerId: String) {
        viewModelScope.launch {
            try {
                val speaker = getSpeakersUseCase.getSpeakerById(speakerId)
                _speaker.value = speaker
            } catch (e: Exception) {
                // Tratar erros adequadamente, talvez atualizar um estado de erro no LiveData
            }
        }
    }
}
