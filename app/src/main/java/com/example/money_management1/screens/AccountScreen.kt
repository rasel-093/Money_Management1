package com.example.money_management1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.money_management1.components.TopBar

@Composable
fun AccountScreen(innerPadding: PaddingValues) {
    Scaffold(
        topBar = { TopBar("Account") },
        modifier = Modifier.padding(innerPadding)
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text(text = "Rasel")
        }
    }
}