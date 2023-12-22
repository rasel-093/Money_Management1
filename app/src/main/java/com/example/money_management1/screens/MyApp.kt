package com.example.money_management1.screens

import android.content.Context
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.money_management1.components.bottom_navigation_components.BottomNavigationBar
import com.example.money_management1.components.bottom_navigation_components.NavHostContainer

@Composable
fun MyApp(navController: NavHostController , context: Context) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {innerPadding->
//        NavHostContainer(
//            navController = navController ,
//            padding = innerPadding ,
//            context = context)
    }
}