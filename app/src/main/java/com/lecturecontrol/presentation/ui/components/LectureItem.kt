package com.lecturecontrol.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lecturecontrol.R
import com.lecturecontrol.domain.model.Lecture
import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.presentation.navigation.Routes
import com.lecturecontrol.utils.asyncImageLoad

@Composable
fun LectureItem(
    lecture: Lecture,
    speaker: Speaker,
    context: Context,
    navController: NavController,
    isFirstItem: Boolean = false,
    onFavoriteClick: () -> Unit
) {
    val speakerImageBitmap = asyncImageLoad(context, speaker.imageUrl)
    val companyImageBitmap = asyncImageLoad(context, speaker.companyImageUrl)

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(
                start = 20.dp,
                top = if (isFirstItem) 0.dp else 21.dp,
                end = 20.dp,
                bottom = 8.dp
            ),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .clickable { navController.navigate(Routes.SpeakerDetails.createRoute(lecture.speakerId)) }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            speakerImageBitmap.value?.let { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Speaker Picture",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = lecture.subject,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    companyImageBitmap.value?.let { bitmap ->
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = "Company Picture",
                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape)
                        )
                    }
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = speaker.company,
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray
                    )
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "Date",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colors.onSurface
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = lecture.date,
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray
                    )
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_room),
                        contentDescription = "Location",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colors.onSurface
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = lecture.meetRoom,
                        style = MaterialTheme.typography.caption,
                        color = Color.Gray
                    )
                }
            }
            IconButton(onClick = { onFavoriteClick() }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = if (lecture.isFavorite) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(
                        alpha = 0.3f
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun LectureItemPreview() {
    val context = LocalContext.current
    val navController = rememberNavController()
//    val lecture = (
//        id = "fb1db778-354e-4e71-b4b6-784631d060f5",
//        subject = "Subject 1",
//        date = "2024-12-12",
//        meetRoom = "Room 10",
//        isFavorite = true,
//        speakerId = "b6ef664d-ae0c-4e92-9e5b-c2c46a998181",
//    )
//    LectureItem(
//        lecture = lecture,
//        context = context,
//        navController = navController,
//        onFavoriteClick = {}
//    )
}