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
import com.lecturecontrol.domain.model.Portfolio
import com.lecturecontrol.domain.model.Speaker

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
    SpeakerContacts(
        speaker = Speaker(
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
                Portfolio(
                    name = "/carlasouza",
                    imageUrl = "https://picsum.photos/200/300?random=1"
                ),
                Portfolio(
                    name = "/huehuehue", imageUrl = "https://picsum.photos/200/300?random=1",
                )
            )
        )
    )
}
