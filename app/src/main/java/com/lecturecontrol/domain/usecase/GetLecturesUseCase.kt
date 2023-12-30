package com.lecturecontrol.domain.usecase

import com.lecturecontrol.domain.model.Lecture
import com.lecturecontrol.domain.repository.LectureRepository

class GetLecturesUseCase(private val repository: LectureRepository) {
    operator fun invoke(): List<Lecture> {
        return repository.getLectures()
    }
}