package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.utils.asyncImageLoad

@Composable
fun PortfolioItem(portfolio: Portfolio) {
    val portfolioPictureImageBitmap =
        asyncImageLoad(LocalContext.current, portfolio.imageUrl).value?.asImageBitmap()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {
        portfolioPictureImageBitmap?.let {
            Image(
                bitmap = it,
                contentDescription = "Portfolio Picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = portfolio.name,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PortfolioItemPreview() {
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
    PortfolioItem(portfolio = speaker.portfolio[0])
}