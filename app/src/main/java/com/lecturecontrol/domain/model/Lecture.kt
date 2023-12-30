package com.lecturecontrol.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lecture(
    val id: String,
    val subject: String,
    val company: String,
    val date: String,
    val meetRoom: String,
    val isFavorite: Boolean = false,
    val speakerId: String,
    val speakerPicture: String,
    val companyPicture: String
) : Parcelable