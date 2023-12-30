package com.lecturecontrol.domain.usecase

import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.domain.repository.SpeakerRepository

class GetSpeakerUseCase(private val repository: SpeakerRepository) {
    fun getSpeakerById(speakerId: String): Speaker {
        return repository.getSpeakerById(speakerId)
    }
}