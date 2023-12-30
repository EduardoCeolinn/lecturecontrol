package com.lecturecontrol.domain.repository

import com.lecturecontrol.domain.model.Lecture

interface LectureRepository {
    fun getLectures(): List<Lecture>
}