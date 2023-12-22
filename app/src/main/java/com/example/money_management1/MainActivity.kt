package com.example.money_management1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.money_management1.components.bottom_navigation_components.BottomNavigationBar
import com.example.money_management1.components.bottom_navigation_components.NavHostContainer
import com.example.money_management1.screens.LoginScreen
import com.example.money_management1.screens.MyApp
import com.example.money_management1.ui.theme.Money_Management1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = applicationContext
            Money_Management1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                  //  MyApp(navController = navController , context = context )
                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController = navController) }
                    ) {innerPadding->
                     //   LoginScreen(navController)
                        NavHostContainer(
                            navController = navController,
                            padding = innerPadding ,
                            context = context
                            )
                    }
                }
            }
        }
    }
}
