package com.example.money_management1.components.bottom_navigation_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person

object BottomNavItems {
    val bottomNavItem = listOf<BottomNavItem>(
        BottomNavItem(
            label = "Home",
            unselectedIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Account",
            unselectedIcon = Icons.Outlined.Person,
            selectedIcon = Icons.Filled.Person,
            route = "account"
        )
    )
}