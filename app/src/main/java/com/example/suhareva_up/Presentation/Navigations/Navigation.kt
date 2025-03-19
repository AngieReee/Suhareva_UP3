package com.example.suhareva_up.Presentation.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.suhareva_up.Presentation.Screens.RegScreen.RegScreen
import com.example.suhareva_up.Presentation.Screens.SplashScreen.SplashScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.REG){

        composable(NavigationRoutes.SPLASH){
            SplashScreen(navController)
        }

        composable(NavigationRoutes.REG){
            RegScreen(navController)
        }
    }
}