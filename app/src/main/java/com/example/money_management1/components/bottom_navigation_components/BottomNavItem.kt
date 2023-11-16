package com.example.money_management1.components.bottom_navigation_components

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label:String,
    val selectedIcon: ImageVector,
    val unselectedIcon:ImageVector,
    val route:String
)