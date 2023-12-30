package com.lecturecontrol.presentation.ui.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object VisitorGuide : Routes("visitorguide")
    data object InteractiveMap : Routes("interactivemap")
    data object MeetingRoom : Routes("meetingroom")
    data object Profile : Routes("profile")
    data object Sponsors : Routes("sponsors")
    data object Settings : Routes("settings")
    data object SpeakerDetails : Routes("speakerDetails/{speakerId}") {
        fun createRoute(speakerId: String) = "speakerDetails/$speakerId"
    }
}
