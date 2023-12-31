package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker

@Composable
fun SpeakerPortfolio(speakerPortfolio: List<Portfolio>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        speakerPortfolio.forEach { porfolio ->
            PortfolioItem(portfolio = porfolio)
        }
    }
}

@Preview
@Composable
fun SpeakerPortfolioPreview() {
    val speaker = Speaker(
        id = "936267bb-0d59-4100-9afd-5358076f5855",
        shortName = "Carlos Santos",
        fullName = "Carlos Santos Silva Junior",
        imageUrl = "https://picsum.photos/200/300?random=1",
        company = "Company A",
        title = "Desenvolvedor Java",
        companyImageUrl = "https://picsum.photos/200/300?random=2",
        biography = "Trabalhando no mundo da tecnologia há 6 anos, minha paixão é criar software que faça a diferença. Com um profundo conhecimento em linguagens de programação como S4 Hana e Phyton, estou sempre em busca de desafios que me permitam inovar e crescer como desenvolvedor.",
        instagram = "@carlossa",
        phone = "(11) 96576-2171",
        email = "39f0548b@email.com",
        portfolio = listOf(
            Portfolio(name = "/carlasouza", imageUrl = "https://picsum.photos/200/300?random=1"),
            Portfolio(
                name = "/huehuehue", imageUrl = "https://picsum.photos/200/300?random=1",
            )
        )
    )
    SpeakerPortfolio(speakerPortfolio = speaker.portfolio)
}
