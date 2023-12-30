package com.lecturecontrol.utils

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun asyncImageLoad(context: Context, url: String?): State<Bitmap?> {
    val imageBitmap = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(url) {
        imageBitmap.value = withContext(Dispatchers.IO) {
            Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .submit()
                .get()
        }
    }

    return imageBitmap
}