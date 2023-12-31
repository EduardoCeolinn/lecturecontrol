package com.lecturecontrol.presentation.ui.screens.speaker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lecturecontrol.presentation.ui.components.SpeakerContacts
import com.lecturecontrol.presentation.ui.components.SpeakerPortfolio
import com.lecturecontrol.presentation.viewmodel.SpeakerViewModel
import com.lecturecontrol.utils.asyncImageLoad
import org.koin.androidx.compose.getViewModel

@Composable
fun SpeakerDetailsContent(speakerId: String, topBarTitle: MutableState<String>) {
    val speakerViewModel: SpeakerViewModel = getViewModel()
    speakerViewModel.getSpeakerById(speakerId)

    val speaker by speakerViewModel.speaker.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        speaker?.let { speaker ->
            topBarTitle.value = speaker.shortName
            val speakerPictureImageBitmap =
                asyncImageLoad(LocalContext.current, speaker.imageUrl).value?.asImageBitmap()
            val companyPictureImageBitmap =
                asyncImageLoad(
                    LocalContext.current,
                    speaker.companyImageUrl
                ).value?.asImageBitmap()

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        speakerPictureImageBitmap?.let {
                            Image(
                                bitmap = it,
                                contentDescription = "Speaker Picture",
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape)
                                    .align(Alignment.Center),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = speaker.fullName,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        companyPictureImageBitmap?.let {
                            Image(
                                bitmap = it,
                                contentDescription = "Company Picture",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "${speaker.company} | ${speaker.title}",
                            style = MaterialTheme.typography.body2,
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Biografia",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = speaker.biography,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Contatos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SpeakerContacts(speaker)
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Portfólios",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SpeakerPortfolio(speakerPortfolio = speaker.portfolio)
                }
            }
        } ?: CircularProgressIndicator()
    }
}

@Preview
@Composable
fun SpeakerDetailsContentPreview() {
    val topBarTitle = remember { mutableStateOf("") }
    SpeakerDetailsContent(
        speakerId = "936267bb-0d59-4100-9afd-5358076f5855",
        topBarTitle = topBarTitle
    )
}