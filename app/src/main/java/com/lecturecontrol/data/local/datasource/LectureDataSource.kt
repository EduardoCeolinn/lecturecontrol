package com.lecturecontrol.data.local.datasource

import com.lecturecontrol.domain.model.Lecture

class LectureDataSource {
    fun getLectures(): List<Lecture> = listOf(
        Lecture(
            id = "fb1db778-354e-4e71-b4b6-784631d060f5",
            subject = "Subject 1",
            company = "Company B",
            date = "12 Dez, 16h30",
            meetRoom = "Sala Dino",
            isFavorite = true,
            speakerId = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
            speakerPicture = "https://picsum.photos/100/300?random=3",
            companyPicture = "https://picsum.photos/200/300?random=8"
        ), Lecture(
            id = "156ff137-dfd3-40b5-9bfa-f2ea0d2883f2",
            subject = "Subject 2",
            company = "Company A",
            date = "15 Jan, 13h00",
            meetRoom = "Sala 4",
            isFavorite = false,
            speakerId = "936267bb-0d59-4100-9afd-5358076f5855",
            speakerPicture = "https://picsum.photos/200/300?random=1",
            companyPicture = "https://picsum.photos/200/300?random=7"
        ), Lecture(
            id = "0f30a365-29b0-40cd-bcb5-464667689d14",
            subject = "Subject 3",
            company = "Company B",
            date = "18 Jan, 10h00",
            meetRoom = "Sala Marcelo",
            isFavorite = false,
            speakerId = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
            speakerPicture = "https://picsum.photos/100/300?random=3",
            companyPicture = "https://picsum.photos/200/300?random=8"
        )
    )
}