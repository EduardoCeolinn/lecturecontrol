package com.lecturecontrol.data.local.repository

import com.lecturecontrol.data.local.datasource.LectureDataSource
import com.lecturecontrol.domain.model.Lecture
import com.lecturecontrol.domain.repository.LectureRepository

class LectureRepositoryImpl(private val dataSource: LectureDataSource) : LectureRepository {
    override fun getLectures(): List<Lecture> {
        return dataSource.getLectures()
    }
}