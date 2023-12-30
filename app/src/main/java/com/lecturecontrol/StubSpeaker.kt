package com.lecturecontrol

import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker

val mockedSpeaker: Speaker
    get() = Speaker(
        id = "936267bb-0d59-4100-9afd-5358076f5855",
        name = "Carlos Santos",
        fullName = "Carlos Santos Silva Junior",
        picture = "https://picsum.photos/200/300?random=1",
        company = "Company A",
        title = "Desenvolvedor Java",
        companyPicture = "https://picsum.photos/200/300?random=2",
        biography = "Trabalhando no mundo da tecnologia há 6 anos, minha paixão é criar software que faça a diferença. Com um profundo conhecimento em linguagens de programação como S4 Hana e Phyton, estou sempre em busca de desafios que me permitam inovar e crescer como desenvolvedor.",
        instagram = "@carlossa",
        phone = "(11) 96576-2171",
        email = "39f0548b@email.com",
        portfolio = listOf(
            Portfolio(name = "/carlasouza", picture = "https://picsum.photos/200/300?random=1"),
            Portfolio(
                name = "/huehuehue", picture = "https://picsum.photos/200/300?random=1",
            )
        )
    )