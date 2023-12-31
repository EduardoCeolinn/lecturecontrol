package com.lecturecontrol.data.local.datasource

import com.lecturecontrol.domain.model.Lecture

class LectureDataSource {
    private val speakers = mutableListOf(
        Lecture(
            id = "fb1db778-354e-4e71-b4b6-784631d060f5",
            subject = "Inovações em Inteligência Artificial",
            date = "13 Jan, 14h00",
            meetRoom = "Sala IA",
            isFavorite = false,
            speakerId = "936237bb-0d79-4300-9afd-5368078f5333",
        ),
        Lecture(
            id = "2d33181f-d1f0-4565-87d9-af7f57954b22",
            subject = "O Futuro da Energia Renovável",
            date = "12 Dez, 16h30",
            meetRoom = "Sala Energy",
            isFavorite = false,
            speakerId = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
        ),
        Lecture(
            id = "19793e5c-55b3-49b5-a010-8c54172c2267",
            subject = "Avanços em Computação Quântica",
            date = "12 Dez, 16h30",
            meetRoom = "Sala Energy",
            isFavorite = true,
            speakerId = "936237bb-0d79-4300-9afd-5368078f5333",
        ),
        Lecture(
            id = "0a62b1d3-7cbc-441b-b0cd-f8f3df510548",
            subject = "Entendendo a Tecnologia Blockchain",
            date = "12 Dez, 16h30",
            meetRoom = "Sala IA",
            isFavorite = false,
            speakerId = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
        ),
        Lecture(
            id = "0a854691-7ad1-41ee-b9b5-0936fbe2375e",
            subject = "Explorando o Universo Web",
            date = "12 Dez, 16h30",
            meetRoom = "Sala Principal",
            isFavorite = false,
            speakerId = "236257bb-0d69-4300-9atd-5368078f59988",
        )
    )

    fun getLectures(): List<Lecture> = speakers
}