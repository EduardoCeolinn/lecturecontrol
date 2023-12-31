package com.lecturecontrol.domain.model

data class Speaker(
    val id: String,
    val shortName: String,
    val fullName: String,
    val imageUrl: String,
    val company: String,
    val title: String,
    val companyImageUrl: String,
    val biography: String,
    val instagram: String,
    val phone: String,
    val email: String,
    val portfolio: List<Portfolio>
)