package com.example.money_management1.components.bottom_navigation_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import com.example.money_management1.R

object BottomNavItems {
    val bottomNavItem = listOf<BottomNavItem>(
        BottomNavItem(
            label = "Home",
            unselectedIcon = R.drawable.home_icon,
            selectedIcon = R.drawable.home_icon,
            route = "home"
        ),
        BottomNavItem(
            label = "Goals",
            unselectedIcon = R.drawable.goals,
            selectedIcon = R.drawable.goals,
            route = "goals"
        ),
        BottomNavItem(
            label = "Overview",
            unselectedIcon = R.drawable.overview,
            selectedIcon = R.drawable.overview,
            route = "overview"
        ),
        BottomNavItem(
            label = "Tips",
            unselectedIcon = R.drawable.tips,
            selectedIcon = R.drawable.tips,
            route = "tips"
        )
    )
}