package com.lecturecontrol.data.local.datasource

import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker

class SpeakerDataSource {
    private val speakers = listOf(
        Speaker(
            id = "936267bb-0d59-4100-9afd-5358076f5855",
            name = "Carlos Santos",
            fullName = "Carlos Santos Silva Junior",
            picture = "https://picsum.photos/200/300?random=1",
            company = "Company A",
            title = "Desenvolvedor Java",
            companyPicture = "https://picsum.photos/200/300?random=2",
            biography = "Trabalhando no mundo da tecnologia há 6 anos, minha paixão é criar software que faça a diferença. Com um profundo conhecimento em linguagens de programação como S4 Hana e Phyton, estou sempre em busca de desafios que me permitam inovar e crescer como desenvolvedor.",
            instagram = "5ae03810@instagram.com",
            phone = "+55 66 96576-2171",
            email = "39f0548b@email.com",
            portfolio = listOf(
                Portfolio(name = "/carlasouza", picture = "https://picsum.photos/200/300?random=1"),
                Portfolio(
                    name = "/huehuehue", picture = "https://picsum.photos/200/300?random=1",
                )
            )
        ), Speaker(
            id = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
            name = "Luis Eduardo",
            fullName = "Luis Eduardo Ceolin Teste",
            picture = "https://picsum.photos/200/300?random=3",
            company = "Company B",
            title = "Desenvolvedor Kotlin",
            companyPicture = "https://picsum.photos/200/300?random=4",
            biography = "Trabalhando no mundo da tecnologia há 6 anos, minha paixão é criar software que faça a diferença. Com um profundo conhecimento em linguagens de programação como S4 Hana e Phyton, estou sempre em busca de desafios que me permitam inovar e crescer como desenvolvedor.",
            instagram = "@duuhceolin",
            phone = "(43) 99651-2903",
            email = "eduardo_ceolin@hotmail.com",
            portfolio = listOf(
                Portfolio(
                    name = "/huehuehue", picture = "https://picsum.photos/200/300?random=1",
                )
            )
        )
    )

    fun getSpeakerById(speakerId: String): Speaker {
        return speakers.find { it.id == speakerId }!!
    }

}