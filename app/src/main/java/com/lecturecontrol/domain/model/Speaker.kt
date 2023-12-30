package com.lecturecontrol.domain.model

data class Speaker(
    val id: String,
    val name: String,
    val fullName: String,
    val picture: String,
    val company: String,
    val title: String,
    val companyPicture: String,
    val biography: String,
    val instagram: String,
    val phone: String,
    val email: String,
    val portfolio: List<Portfolio>
)

data class Portfolio(
    val name: String,
    val picture: String,
)