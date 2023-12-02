package com.example.money_management1.components.bottom_navigation_components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController){
    NavigationBar(containerColor = Color(239,236,236)) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        //var previousRoute = navBackStackEntry?.destination?.route
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        BottomNavItems.bottomNavItem.forEach { navItem ->

            // Place the bottom nav items
            //Log.d("Route start",lastItemClicked)

            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    if(currentRoute != navItem.route){
                        navController.navigate(navItem.route){
                            //Limit backStack
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },

                // Icon of navItem
                icon = {
                    if( currentRoute == navItem.route)
                        Icon(
                            painter = painterResource(id = navItem.selectedIcon),
                            contentDescription = null)
                        //Icon(imageVector = navItem.selectedIcon, contentDescription = navItem.label)
                    else
                        Icon(
                            painter = painterResource(id = navItem.unselectedIcon) ,
                            contentDescription = null )
                        //Icon(imageVector = navItem.unselectedIcon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF16AA9B),
                    selectedTextColor = Color(0xFF16AA9B),
                    indicatorColor = Color(0xFFFFFFFF),
                    unselectedTextColor = Color(0xFF161313)
                )
            )
        }
    }
}