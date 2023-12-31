package com.lecturecontrol.domain.repository

import com.lecturecontrol.domain.model.Speaker

interface SpeakerRepository {
    fun getSpeakerById(speakerId: String): Speaker
    fun getAllSpeakers(): List<Speaker>
}
