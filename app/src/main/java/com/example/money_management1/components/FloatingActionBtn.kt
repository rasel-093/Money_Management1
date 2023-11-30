package com.example.money_management1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.money_management1.R

@Composable
fun FloatingActionBtn(onClick: (Boolean)->Unit) {
    FloatingActionButton(
        onClick = { onClick(true) },
        containerColor = Color(0xFFFFFFFF),
        modifier = Modifier.offset(y = -65.dp)
    ) {
        Row(Modifier.padding(10.dp)){
            Image(
                painter = painterResource(id = R.drawable.add_icon), 
                contentDescription = null
            )
            Text(text = "Add")
        }
    }
}