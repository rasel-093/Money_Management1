package com.example.money_management1.components.bottom_navigation_components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.money_management1.model.trxmodel.TrxViewModel
import com.example.money_management1.screens.GoalsScreen
import com.example.money_management1.screens.HomeScreen
import com.example.money_management1.screens.OverViewScreen


@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues,
    trxViewModel: TrxViewModel
) {
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){ HomeScreen(innerPadding = padding, navController, trxViewModel)}
        composable("goals"){ GoalsScreen(paddingValues = padding)}
        composable("overview"){ OverViewScreen(paddingValues = padding)}
    }
}