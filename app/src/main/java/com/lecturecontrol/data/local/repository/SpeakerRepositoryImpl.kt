package com.lecturecontrol.data.local.repository

import com.lecturecontrol.data.local.datasource.SpeakerDataSource
import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.domain.repository.SpeakerRepository

class SpeakerRepositoryImpl(private val dataSource: SpeakerDataSource) : SpeakerRepository {
    override fun getSpeakerById(speakerId: String): Speaker {
        return dataSource.getSpeakerById(speakerId)
    }

    override fun getAllSpeakers(): List<Speaker> {
        return dataSource.getAllSpeakers()
    }
}