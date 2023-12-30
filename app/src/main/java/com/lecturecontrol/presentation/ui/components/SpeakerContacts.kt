package com.lecturecontrol.presentation.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lecturecontrol.R
import com.lecturecontrol.domain.model.Speaker
import com.lecturecontrol.mockedSpeaker

@Composable
fun SpeakerContacts(speaker: Speaker) {
    val context = LocalContext.current

    fun openInstagram(username: String) {
        val uri = Uri.parse("http://instagram.com/_u/$username")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.instagram.android")

        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/$username")
                )
            )
        }
    }

    fun composeEmail(address: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$address")
        }

        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
    // TODO JOGAR TUDO P OUTRAS CLASSES UTIL TALVEZ

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ContactItem(
            iconId = R.drawable.ic_instagram,
            contact = speaker.instagram,
            onClick = { openInstagram(speaker.instagram) }
        )

        ContactItem(
            iconId = R.drawable.ic_mail,
            contact = speaker.email,
            onClick = { composeEmail(speaker.email) }
        )

        ContactItem(
            iconId = R.drawable.ic_phone,
            contact = speaker.phone,
            onClick = { dialPhoneNumber(speaker.phone) }
        )
    }
}

@Preview
@Composable
fun SpeakerContactsPreview() {
    SpeakerContacts(speaker = mockedSpeaker)
}
