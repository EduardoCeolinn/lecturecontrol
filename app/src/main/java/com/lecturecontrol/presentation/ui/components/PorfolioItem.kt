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
import com.lecturecontrol.mockedSpeaker
import com.lecturecontrol.utils.asyncImageLoad

@Composable
fun PortfolioItem(portfolio: Portfolio) {
    val portfolioPictureImageBitmap =
        asyncImageLoad(LocalContext.current, portfolio.picture).value?.asImageBitmap()

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
                    .size(24.dp)
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
    PortfolioItem(portfolio = mockedSpeaker.portfolio[0])
}