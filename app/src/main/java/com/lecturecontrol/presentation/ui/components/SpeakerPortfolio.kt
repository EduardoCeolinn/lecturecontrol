package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.mockedSpeaker

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
    SpeakerPortfolio(speakerPortfolio = mockedSpeaker.portfolio)
}
