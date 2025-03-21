package com.example.suhareva_up.Presentation.Navigations

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.suhareva_up.Presentation.Screens.MainScreen.MainScreen
import com.example.suhareva_up.Presentation.Screens.RegScreen.RegScreen
import com.example.suhareva_up.Presentation.Screens.SignIn.SignInScreen.SignInScreen
import com.example.suhareva_up.Presentation.Screens.SplashScreen.SplashScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoutes.SPLASH,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }){

        composable(NavigationRoutes.SPLASH){
            SplashScreen(navController)
        }

        composable(NavigationRoutes.REG){
            RegScreen(navController)
        }

        composable(NavigationRoutes.SIGNIN){
            SignInScreen(navController)
        }

        composable(NavigationRoutes.MAIN){
            MainScreen(navController)
        }
    }
}