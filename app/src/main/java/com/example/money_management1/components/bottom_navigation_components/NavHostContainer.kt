package com.example.money_management1.components.bottom_navigation_components

import TipsScreen
import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.money_management1.model.savingmodel.SavingItemViewModel
import com.example.money_management1.model.trxmodel.TrxViewModel
import com.example.money_management1.screens.GoalsScreen
import com.example.money_management1.screens.HomeScreen
import com.example.money_management1.screens.OverViewScreen


@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues,
    context: Context
) {
    val trxViewModel: TrxViewModel = viewModel(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TrxViewModel(context as Application) as  T
            }
        }
    )
    val savingItemViewModel: SavingItemViewModel = viewModel(
        factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SavingItemViewModel(context as Application) as  T
            }
        }
    )
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){ HomeScreen(innerPadding = padding, navController, trxViewModel, savingItemViewModel)}
        composable("goals"){ GoalsScreen(paddingValues = padding, savingItemViewModel)}
        composable("overview"){ OverViewScreen(paddingValues = padding, trxViewModel)}
        composable("tips"){TipsScreen(paddingValues = padding, savingItemViewModel, trxViewModel)}
        //composable("myapp"){ MyApp(navController = navController , context = context )}
        //composable("loginscreen"){ LoginScreen(navController)}
        //composable("signupscreen"){ SignUpScreen(navController)}
    }
}