package com.example.money_management1.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.money_management1.ui.theme.blackFont

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = blackFont,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontSynthesis = FontSynthesis.Style,
            fontFamily = FontFamily.Monospace
        ),
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun BodyText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            color = blackFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontSynthesis = FontSynthesis.Style,
            fontFamily = FontFamily.Monospace
        ),
        modifier = Modifier.padding(4.dp)
    )
}