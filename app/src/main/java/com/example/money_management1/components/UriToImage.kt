package com.example.money_management1.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.SuccessResult

@Composable
fun UriToImage(imageUri: Uri) {
    val painter =
        rememberAsyncImagePainter(model = imageUri) //rememberAsyncImagePainter(model = imageUri)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.Gray)
    )
}

 suspend fun UriToBitmap(uri: Uri,context: Context): Bitmap{
    val loading = ImageLoader(context)
    val request = ImageRequest.Builder(context)
        .data(uri)
        .build()
    val result = (loading.execute(request) as SuccessResult).drawable
    return (result as BitmapDrawable).bitmap
}